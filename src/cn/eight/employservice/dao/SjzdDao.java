package cn.eight.employservice.dao;

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

    public List<Sjzd> queryAllData(int pageNow, int pageSize){
        List<Sjzd> resultList=new ArrayList<>();

        String sql="select * from sjzd order by id limit ?,?";
        Connection con = DbPool.getConnection();
        PreparedStatement pst=null;
        ResultSet rs=null;
        try {
            con.prepareStatement(sql);
            rs=basicDao.execQuery(con,pst,(pageNow-1)*pageSize,pageSize);
            while (rs!=null&&rs.next()){
                Sjzd sjzd=new Sjzd();
                sjzd.setId(rs.getInt(1));
                sjzd.setName(rs.getString(2));
                sjzd.setRemarks(rs.getString(3));
                sjzd.setSort(rs.getInt(4));
                resultList.add(sjzd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basicDao.releaseResourse(rs,pst,con);
        }
        return resultList;
    }
}
