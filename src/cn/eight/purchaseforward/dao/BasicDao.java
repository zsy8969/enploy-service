package cn.eight.purchaseforward.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//实现公共的功能,减少代码冗余
public class BasicDao {
    //公共的查询功能
    public ResultSet execQuery(Connection con, PreparedStatement pst, Object... params) {
        ResultSet rs = null;
        try {
            if (params!=null){
                for (int i = 0; i < params.length; i++) {
                    pst.setObject(i + 1, params[i]);
                }
            }
            rs = pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //公共的修改功能
    public void execUpdate(Connection con, PreparedStatement pst, Object... params) throws SQLException {
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                pst.setObject(i + 1, params[i]);
            }
            pst.executeUpdate();
        }

    }

    //公共释放资源的方法
    public void releaseResourse(ResultSet rs, PreparedStatement pst, Connection con) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
                con = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
