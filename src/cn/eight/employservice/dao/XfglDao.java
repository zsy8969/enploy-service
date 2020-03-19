package cn.eight.employservice.dao;

import cn.eight.employservice.pojo.Xfgl;
import cn.eight.employservice.util.DbPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 瞿琮
 * @create 2020-03-19 10:31
 */
public class XfglDao {

    private BasicDao basicDao = new BasicDao();

    //查询所有记录
    public List<Xfgl> queryAll(int pageNow,int pageSize){
        List<Xfgl> resultList = new ArrayList<>();
        String sql="select * from slotcard order by consume_id limit ?,?";

        Connection con = DbPool.getConnection();
        PreparedStatement pst =null;
        ResultSet rs =null;
        try {
            pst = con.prepareStatement(sql);
            rs = basicDao.execQuery(con, pst, (pageNow - 1) * pageSize, pageSize);
            while (rs!=null&&rs.next()){
                Xfgl datas=new Xfgl();
                datas.setConsume_id(rs.getInt(1));
                datas.setCompany_id(rs.getInt(2));
                datas.setConsume_money(rs.getFloat(3));
                datas.setConsume_time(rs.getString(4));
                datas.setConsume_typeInt(rs.getInt(5));
                resultList.add(datas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basicDao.releaseResourse(rs,pst,con);
        }
        return resultList;
    }

    //得到总记录数
    public int totalRecord(String startTime,String endTime){
        String sql= null;
        int i=0;
        if (startTime==null&&endTime==null){
            sql="select count(*) from slotcard";
        }else {
            sql="select count(*) from slotcard where consume_time between ? and ?";
            i++;
        }

        Connection con = DbPool.getConnection();
        PreparedStatement pst=null;
        ResultSet rs =null;
        int result=0;
        try {
            pst = con.prepareStatement(sql);
            if (i==0){
                rs = basicDao.execQuery(con, pst, null);
            }else {
                rs = basicDao.execQuery(con, pst,startTime,endTime);
            }

            while (rs!=null&&rs.next()){
                result=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basicDao.releaseResourse(rs,pst,con);
        }
        return result;
    }

    //按时间查询数据
    public List<Xfgl> queryByTime(String startTime,String endTime,int pageNow,int pageSize){
        List<Xfgl> resultList = new ArrayList<>();

        String sql="select * from slotcard where consume_time between ? and ? order by consume_id limit ?,?";
        Connection con = DbPool.getConnection();
        PreparedStatement pst=null;
        ResultSet rs =null;
        try {
            pst = con.prepareStatement(sql);
            rs = basicDao.execQuery(con, pst, startTime, endTime,(pageNow-1)*pageSize,pageSize);
            while (rs!=null&&rs.next()){
                Xfgl xfgl=new Xfgl();
                xfgl.setConsume_id(rs.getInt(1));
                xfgl.setCompany_id(rs.getInt(2));
                xfgl.setConsume_money(rs.getFloat(3));
                xfgl.setConsume_time(rs.getString(4));
                xfgl.setConsume_typeInt(rs.getInt(5));
                resultList.add(xfgl);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basicDao.releaseResourse(rs,pst,con);
        }
        return resultList;
    }
}
