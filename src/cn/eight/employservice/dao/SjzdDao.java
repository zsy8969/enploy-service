package cn.eight.employservice.dao;

import cn.eight.employservice.pojo.Company;
import cn.eight.employservice.pojo.Sjzd;
import cn.eight.employservice.util.DbPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 瞿琮
 * @create 2020-03-18 10:39
 */
public class SjzdDao {

    private BasicDao basicDao= new BasicDao();

    //查询所有数据
    public List<Sjzd> queryAllData(int pageNow, int pageSize){
        List<Sjzd> resultList=new ArrayList<>();

        String sql="select * from sjzd order by id limit ?,?";
        Connection con = DbPool.getConnection();
        PreparedStatement pst=null;
        ResultSet rs=null;
        try {
            pst=con.prepareStatement(sql);
            rs=basicDao.execQuery(con,pst,(pageNow-1)*pageSize,pageSize);
            while (rs!=null&&rs.next()){
                Sjzd sjzd=new Sjzd();
                sjzd.setId(rs.getInt(1));
                sjzd.setName(rs.getString(2));
                sjzd.setRemarks(rs.getString(3));
                sjzd.setSortInt(rs.getInt(4));
                resultList.add(sjzd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basicDao.releaseResourse(rs,pst,con);
        }
        return resultList;
    }

    //中记录数
    //得到总记录数
    public int totalRecord(){
        String sql="select count(*) from sjzd";
        Connection con = DbPool.getConnection();
        PreparedStatement pst=null;
        ResultSet rs =null;
        int result=0;
        try {
            pst = con.prepareStatement(sql);
            rs = basicDao.execQuery(con, pst, null);
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

    //按条件记录
    public List<Sjzd> queryDataByCritria(int sortInt){

        List<Sjzd> resultList=new ArrayList<>();

        String sql="select * from sjzd where sort="+sortInt;

        Connection con = DbPool.getConnection();
        PreparedStatement pst=null;
        ResultSet rs=null;
        try {
            pst = con.prepareStatement(sql);
            rs = basicDao.execQuery(con, pst, null);
            while (rs!=null&&rs.next()){
                Sjzd sjzd=new Sjzd();
                sjzd.setId(rs.getInt(1));
                sjzd.setName(rs.getString(2));
                sjzd.setRemarks(rs.getString(3));
                sjzd.setSortInt(rs.getInt(4));
                resultList.add(sjzd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basicDao.releaseResourse(rs,pst,con);
        }
        return resultList;
    }

    //新增数据
    public boolean addData(Sjzd data){
        boolean result=false;

        String sql="insert into sjzd(name,remarks,sort) values(?,?,?)";
        Connection con = DbPool.getConnection();
        PreparedStatement pst = null;

        try {
            //添加、改变数据库所以要启用事务
            con.setAutoCommit(false);
            pst=con.prepareStatement(sql);
            basicDao.execUpdate(con,pst,data.getName(),data.getRemarks(),data.getSortInt());
            con.commit();
            result=true;
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            basicDao.releaseResourse(null,pst,con);
        }
        return result;
    }

    //删除记录
    public boolean removeData(String[] ids){
        boolean result=false;
        String sql="delete from sjzd where id in ";
        String critria="";
        if (ids.length>0){
            for (int i = 0; i < ids.length; i++) {
                critria+=ids[i]+",";
            }
        }
        if (!critria.isEmpty()){
            int lastIndexOf = critria.lastIndexOf(",");
            critria = critria.substring(0, lastIndexOf);
        }else {
            return false;
        }
        sql+="("+critria+")";
        Connection con = DbPool.getConnection();
        PreparedStatement pst =null;
        try {
            con.setAutoCommit(false);
            pst=con.prepareStatement(sql);
            basicDao.execUpdate(con,pst,null);

            int i=0;
            i = pst.executeUpdate();
            if (i!=0){
                con.commit();
                result=true;
            }
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            basicDao.releaseResourse(null,pst,con);
        }
        return result;
    }

    //修改记录
    public boolean modData(Sjzd datas){
        boolean result=false;

        String sql="update sjzd set name=?,remarks=? where id=?";
        Connection con = DbPool.getConnection();
        PreparedStatement pst = null;

        try {
            //添加、改变数据库所以要启用事务
            con.setAutoCommit(false);
            pst=con.prepareStatement(sql);
            basicDao.execUpdate(con,pst,datas.getName(),datas.getRemarks(),datas.getId());
            int i=0;
            i = pst.executeUpdate();
            if (i!=0){
                con.commit();
                result=true;
            }

        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            basicDao.releaseResourse(null,pst,con);
        }
        return result;
    }
}
