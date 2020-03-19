package cn.eight.employservice.dao;

import cn.eight.employservice.pojo.Company;
import cn.eight.employservice.util.DbPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 瞿琮
 * @create 2020-03-16 18:43
 */
public class GsglDao {

    private BasicDao basicDao= new BasicDao();

    //新增公司
    public boolean addCompany(Company company){
        boolean result=false;

        String sql="insert into company(company_account,company_name,company_intro) values(?,?,?)";
        Connection con = DbPool.getConnection();
        PreparedStatement pst = null;

        try {
            //添加、改变数据库所以要启用事务
            con.setAutoCommit(false);
            pst=con.prepareStatement(sql);
            basicDao.execUpdate(con,pst,company.getCompany_account(),company.getCompany_name(),company.getCompany_intro());
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

    //查询所有公司并分页展示
    public List<Company> queryAllCompany(int pageNow,int pageSize){
        //返回结果集对象
        List<Company> resultList=new ArrayList<>();
        Connection con = DbPool.getConnection();
        PreparedStatement pst =null;
        ResultSet rs =null;
        String sql="select * from company order by company_id limit ?,?";
        try {
            pst = con.prepareStatement(sql);
            rs = basicDao.execQuery(con, pst, (pageNow - 1) * pageSize, pageSize);
            while (rs!=null&&rs.next()){
                Company company=new Company();//封装公司信息对象
                company.setCompany_id(rs.getInt(1));
                company.setCompany_account(rs.getString(2));
                company.setCompany_name(rs.getString(3));
                company.setCompany_intro(rs.getString(4));
                resultList.add(company);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basicDao.releaseResourse(rs,pst,con);
        }
        return resultList;
    }

    //得到总记录数,分条件查询和无条件查询
    public int totalRecord(String company_account, String company_name){
        String sql;
        if (company_account==null&&company_name==null){
            sql="select count(*) from company";
        }else {
            sql="select count(*) from company";
            String critria="";//查询条件语句
            if (!company_account.trim().isEmpty()){
                critria+="company_account='"+company_account+"'";
            }

            if (!company_name.trim().isEmpty()){
                if (!critria.isEmpty()){
                    critria+=" and company_name='"+company_name+"'";
                }else {
                    critria+="company_name='"+company_name+"'";
                }
            }
            sql+=" where "+critria;
        }

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


    //按条件查询公司
    public List<Company> queryCompanyByCritria(String company_account, String company_name,int pageNow,int pageSize){

        List<Company> resultList=new ArrayList<>();

        String sql="select * from company";
        String critria="";//查询条件语句
        if (!company_account.trim().isEmpty()){
            critria+="company_account='"+company_account+"'";
        }

        if (!company_name.trim().isEmpty()){
            if (!critria.isEmpty()){
                critria+=" and company_name='"+company_name+"'";
            }else {
                critria+="company_name='"+company_name+"'";
            }
        }
        sql+=" where "+critria+" limit ?,?";

        Connection con = DbPool.getConnection();
        PreparedStatement pst=null;
        ResultSet rs=null;
        try {
            pst = con.prepareStatement(sql);
            rs = basicDao.execQuery(con, pst, (pageNow-1)*pageSize,pageSize);
            while (rs!=null&&rs.next()){
                Company company=new Company();//封装公司信息对象
                company.setCompany_id(rs.getInt(1));
                company.setCompany_account(rs.getString(2));
                company.setCompany_name(rs.getString(3));
                resultList.add(company);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basicDao.releaseResourse(rs,pst,con);
        }
        return resultList;
    }

    //删除记录
    public boolean removeCompany(String[] ids){
        boolean result=false;
        String sql="delete from company where company_id in ";
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
    public boolean modCompany(Company company){
        boolean result=false;

        String sql="update company set company_account=?,company_name=?,company_intro=? where company_id=?";
        Connection con = DbPool.getConnection();
        PreparedStatement pst = null;

        try {
            //添加、改变数据库所以要启用事务
            con.setAutoCommit(false);
            pst=con.prepareStatement(sql);
            basicDao.execUpdate(con,pst,company.getCompany_account(),company.getCompany_name(),company.getCompany_intro(),company.getCompany_id());
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

    //通过编号查询公司
    public Company findCompanyById(int id){

        Company result=new Company();

        String sql="select * from company where company_id="+id;

        Connection con = DbPool.getConnection();
        PreparedStatement pst=null;
        ResultSet rs=null;
        try {
            pst = con.prepareStatement(sql);
            rs = basicDao.execQuery(con, pst, null);
            while (rs!=null&&rs.next()){
                result.setCompany_id(rs.getInt(1));
                result.setCompany_account(rs.getString(2));
                result.setCompany_name(rs.getString(3));
                result.setCompany_intro(rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basicDao.releaseResourse(rs,pst,con);
        }
        return result;
    }
    }
