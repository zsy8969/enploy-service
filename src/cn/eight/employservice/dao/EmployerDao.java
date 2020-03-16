package cn.eight.employservice.dao;

import cn.eight.employservice.pojo.Employer;
import cn.eight.employservice.pojo.User;
import cn.eight.employservice.util.DbPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployerDao {
    private BasicDao dao = new BasicDao();

    public boolean insertEmployer(Employer employer){
        boolean result = false;
        PreparedStatement pst = null;
        String sql = "insert into employer(name,sex,age,nation,address,edu,idcard,workunit,occ,contractid,contracttime,mphone,phone,nowaddress,resaddress,servaddress,fam_address,fam_people,comrequest,fam_content,fam_area,fam_diet,fam_other,agent,reg_time,high_price,low_price,remark,company_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1)";
        Connection con = DbPool.getConnection();
        try {
            con.setAutoCommit(false);
            pst = con.prepareStatement(sql);
            dao.execUpdate(con,pst,employer.getName(),employer.getSex(),employer.getAge(),employer.getNation(),employer.getAddress(),employer.getEdu(),employer.getIdcard(),employer.getWorkunit(),employer.getOcc(),employer.getContractid(),employer.getContracttime(),employer.getMphone(),employer.getPhone(),
                    employer.getNowaddress(),employer.getResaddress(),employer.getServaddress(),employer.getFam_address(),employer.getFam_people(),employer.getCom_request(),employer.getFam_content(),employer.getFam_area(),employer.getFam_diet(),employer.getFam_other(),employer.getAgent(),employer.getReg_time(),employer.getHigh_price(),employer.getLow_price(),employer.getRemark());
            con.commit();
            result = true;
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            dao.releaseResourse(null,pst,con);
        }
        return result;
    }
}
