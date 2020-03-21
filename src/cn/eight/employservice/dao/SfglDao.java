package cn.eight.employservice.dao;

import cn.eight.employservice.pojo.Deal;
import cn.eight.employservice.pojo.Employer;
import cn.eight.employservice.pojo.Work;
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
 * @create 2020-03-21 10:54
 */
public class SfglDao {
    BasicDao basicDao=new BasicDao();
    //查询所有记录
    public List<Deal> queryAll(int pageNow, int pageSize){
        List<Deal> resultList = new ArrayList<>();
        String sql="select * from deal order by deal_id limit ?,?";

        Connection con = DbPool.getConnection();
        PreparedStatement pst =null;
        ResultSet rs =null;
        try {
            pst = con.prepareStatement(sql);
            rs = basicDao.execQuery(con, pst, (pageNow - 1) * pageSize, pageSize);
            while (rs!=null&&rs.next()){
               Deal deals=new Deal();
               deals.setDealId(rs.getInt(1));
               deals.setCompanyId(rs.getInt(2));
               deals.setEmployerId(rs.getInt(3));
               deals.setWorkId(rs.getInt(4));
               deals.setAgentId(rs.getInt(5));
               deals.setRegTime(rs.getString(6));
               deals.setDealValidity(rs.getString(7));
               deals.setState(rs.getString(8));
               deals.setWage(rs.getInt(9));
               deals.setHireType(rs.getString(10));
               deals.setReferralFee(rs.getInt(11));
               deals.setFixDate(rs.getString(12));
               resultList.add(deals);
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
            sql="select count(*) from deal";
        }else {
            sql="select count(*) from deal where fixture_date between ? and ?";
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

    //按标号查找名称
    public String findNameById(int id,String type){
        String sql=null;
        String name=null;
        if (type.equals("work")){
            sql="select work_name from work where work_id="+id;
        }else if (type.equals("employer")){
            sql="select name from employer where emp_id="+id;
        }

        Connection con = DbPool.getConnection();
        PreparedStatement pst=null;
        ResultSet rs=null;
        try {
            pst=con.prepareStatement(sql);
            rs = basicDao.execQuery(con, pst, null);
            while (rs!=null&&rs.next()){
                name=rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basicDao.releaseResourse(rs,pst,con);
        }
        return name;
    }

    //按时间查询数据
    public List<Deal> queryByTime(String startTime,String endTime,int pageNow,int pageSize){
        List<Deal> resultList = new ArrayList<>();

        String sql="select * from deal where fixture_date between ? and ? order by deal_id limit ?,?";
        Connection con = DbPool.getConnection();
        PreparedStatement pst=null;
        ResultSet rs =null;
        try {
            pst = con.prepareStatement(sql);
            rs = basicDao.execQuery(con, pst, startTime, endTime,(pageNow-1)*pageSize,pageSize);
            while (rs!=null&&rs.next()){
                Deal deals=new Deal();
                deals.setDealId(rs.getInt(1));
                deals.setCompanyId(rs.getInt(2));
                deals.setEmployerId(rs.getInt(3));
                deals.setWorkId(rs.getInt(4));
                deals.setAgentId(rs.getInt(5));
                deals.setRegTime(rs.getString(6));
                deals.setDealValidity(rs.getString(7));
                deals.setState(rs.getString(8));
                deals.setWage(rs.getInt(9));
                deals.setHireType(rs.getString(10));
                deals.setReferralFee(rs.getInt(11));
                deals.setFixDate(rs.getString(12));
                resultList.add(deals);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basicDao.releaseResourse(rs,pst,con);
        }
        return resultList;
    }

    //通过订单编号取出交易记录
    public Deal findDealBydealId(Integer id){
        Deal result=new Deal();
        String sql="select * from deal where deal_id="+id;
        Connection con = DbPool.getConnection();
        PreparedStatement pst=null;
        ResultSet rs=null;
        try {
            pst=con.prepareStatement(sql);
            rs=basicDao.execQuery(con,pst,null);
            while (rs!=null&&rs.next()){
                result.setDealId(rs.getInt(1));
                result.setCompanyId(rs.getInt(2));
                result.setEmployerId(rs.getInt(3));
                result.setWorkId(rs.getInt(4));
                result.setAgentId(rs.getInt(5));
                result.setDealValidity(rs.getString(7));
                result.setState(rs.getString(8));
                result.setWage(rs.getInt(9));
                result.setHireType(rs.getString(10));
                result.setReferralFee(rs.getInt(11));
                result.setFixDate(rs.getString(12));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basicDao.releaseResourse(rs,pst,con);
        }
        return result;
    }

    //通过雇主编号查询雇主信息
    public Employer findEmployerById(int emp_id){
        Employer result = new Employer();
        String sql="select * from employer where emp_id="+emp_id;
        Connection con = DbPool.getConnection();
        PreparedStatement pst=null;
        ResultSet rs=null;
        try {
            pst = con.prepareStatement(sql);
            rs = basicDao.execQuery(con,pst,null);
            while (rs!=null&&rs.next()){
                result.setName(rs.getString(2));
                result.setSex(rs.getString(3));
                result.setAge(rs.getInt(4));
                result.setNation(rs.getString(5));
                result.setAddress(rs.getString(6));
                result.setEdu(rs.getString(7));
                result.setIdcard(rs.getString(8));
                result.setWorkunit(rs.getString(9));
                result.setOcc(rs.getString(10));
                result.setPhone(rs.getString(14));
                result.setNowaddress(rs.getString(15));
                result.setResaddress(rs.getString(16));
                result.setServaddress(rs.getString(17));
                result.setFam_address(rs.getString(18));
                result.setFam_people(rs.getString(19));
                result.setFam_content(rs.getString(21));
                result.setFam_area(rs.getString(22));
                result.setFam_diet(rs.getString(23));
                result.setFam_other(rs.getString(24));
                result.setHigh_price(rs.getFloat(27));
                result.setLow_price(rs.getFloat(28));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basicDao.releaseResourse(rs,pst,con);
        }
        return result;
    }

    //通过工人编号查询供热信息
    public Work findWorkById(int work_id){
        Work result = new Work();
        String sql="select * from work where work_id="+work_id;
        Connection con = DbPool.getConnection();
        PreparedStatement pst=null;
        ResultSet rs=null;
        try {
            pst = con.prepareStatement(sql);
            rs = basicDao.execQuery(con,pst,null);
            while (rs!=null&&rs.next()){
                result.setWork_id(rs.getInt(1));
                result.setWork_name(rs.getString(2));
                result.setSex(rs.getString(3));
                result.setIdcard(rs.getString(4));
                result.setDate(rs.getString(5));
                result.setAge(rs.getInt(6));
                result.setHigh(rs.getInt(7));
                result.setMphone(rs.getString(8));
                result.setWork_type(rs.getString(9));
                result.setPhone(rs.getString(10));
                result.setWork_time(rs.getString(11));
                result.setFlwa(rs.getString(12));
                result.setPic(rs.getString(13));
                result.setSkill(rs.getString(24));
                result.setSelf(rs.getString(25));
                result.setEdu(rs.getString(32));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basicDao.releaseResourse(rs,pst,con);
        }
        return result;
    }
}
