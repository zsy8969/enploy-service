package cn.eight.employservice.dao;

import cn.eight.employservice.pojo.*;
import cn.eight.employservice.util.DbPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployerDao {
    private BasicDao dao = new BasicDao();

    public boolean insertEmployer(Employer employer) {
        boolean result = false;
        PreparedStatement pst = null;
        String sql = "insert into employer(name,sex,age,nation,address,edu,idcard,workunit,occ,contractid,contracttime,mphone,phone,nowaddress,resaddress,servaddress,fam_address,fam_people,comrequest,fam_content,fam_area,fam_diet,fam_other,agent,reg_time,high_price,low_price,remark,company_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1)";
        Connection con = DbPool.getConnection();
        try {
            con.setAutoCommit(false);
            pst = con.prepareStatement(sql);
            dao.execUpdate(con, pst, employer.getName(), employer.getSex(), employer.getAge(), employer.getNation(), employer.getAddress(), employer.getEdu(), employer.getIdcard(), employer.getWorkunit(), employer.getOcc(), employer.getContractid(), employer.getContracttime(), employer.getMphone(), employer.getPhone(),
                    employer.getNowaddress(), employer.getResaddress(), employer.getServaddress(), employer.getFam_address(), employer.getFam_people(), employer.getCom_request(), employer.getFam_content(), employer.getFam_area(), employer.getFam_diet(), employer.getFam_other(), employer.getAgent(), employer.getReg_time(), employer.getHigh_price(), employer.getLow_price(), employer.getRemark());
            con.commit();
            result = true;
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            dao.releaseResourse(null, pst, con);
        }
        return result;
    }


    public boolean insertDeal(Deal deal) {
        boolean result = false;
        PreparedStatement pst = null;
        String sql = "insert into deal(agentid,reg_time,dealtime,statue,price,employ_type,intro_price,deal_time,company_id,work_id,emp_id,other) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection con = DbPool.getConnection();
        try {
            con.setAutoCommit(false);
            pst = con.prepareStatement(sql);
            dao.execUpdate(con, pst, deal.getAgentid(), deal.getReg_time(), deal.getDealtime(), deal.getStatue(), deal.getPrice(), deal.getEmploy_type(), deal.getIntro_price(), deal.getDeal_time(), deal.getCompany_id(), deal.getWork_id(), deal.getEmp_id(),deal.getOther());
            con.commit();
            result = true;
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            dao.releaseResourse(null, pst, con);
        }
        return result;
    }


    public boolean updateDeal(Deal deal) {
        boolean result = false;
        PreparedStatement pst = null;
        String sql = "UPDATE deal SET agentid=?,reg_time=?,dealtime=?,statue=?,price=?,employ_type=?,intro_price=?,deal_time=?,company_id=?,work_id=?,emp_id=?,other=? where dealid=?";
        Connection con = DbPool.getConnection();
        try {
            con.setAutoCommit(false);
            pst = con.prepareStatement(sql);
            dao.execUpdate(con, pst, deal.getAgentid(), deal.getReg_time(), deal.getDealtime(), deal.getStatue(), deal.getPrice(), deal.getEmploy_type(), deal.getIntro_price(), deal.getDeal_time(), deal.getCompany_id(), deal.getWork_id(), deal.getEmp_id(),deal.getOther(),deal.getDealid());
            con.commit();
            result = true;
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            dao.releaseResourse(null, pst, con);
        }
        return result;
    }

    public boolean addRechargeRecord(RechargeRocard rocard) {
        boolean result = false;
        PreparedStatement pst = null;
        String sql = "INSERT into rechargerecord(recompany_id,recharge_money,operator,recharge_time,record) VALUES (?,?,?,?,?)";
        Connection con = DbPool.getConnection();
        try {
            con.setAutoCommit(false);
            pst = con.prepareStatement(sql);
            dao.execUpdate(con,pst,rocard.getCompany_id(),rocard.getRecharge_money(),rocard.getOperator(),rocard.getRecharge_time(),rocard.getRecord());
            con.commit();
            result = true;
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            dao.releaseResourse(null, pst, con);
        }
        return result;
    }

    public List<Employer> queryEmployer(Employer employer) {
        String sql = "SELECT name,sex,age,comrequest,low_price,high_price,reg_time,emp_id from employer";
        String criteria = "";
        if (!employer.getName().trim().isEmpty()) {
            criteria = "name='" + employer.getName() + "'";
        }
        if (!employer.getSex().isEmpty()) {
            if (criteria.isEmpty()) {
                criteria += " sex='" + employer.getSex() + "'";
            } else {
                criteria += " and sex='" + employer.getSex() + "'";
            }
        }
        if (!employer.getPhone().trim().isEmpty()) {
            if (criteria.isEmpty()) {
                criteria += " phone='" + employer.getPhone() + "'";
            } else {
                criteria += " and phone='" + employer.getPhone() + "'";
            }
        }
        if (!employer.getCom_request().trim().isEmpty()) {
            if (criteria.isEmpty()) {
                criteria += " comrequest like '%" + employer.getCom_request() + "%'";
            } else {
                criteria += " and comrequest like '%" + employer.getCom_request() + "%'";
            }
        }
        if (!criteria.isEmpty()) {
            sql += " where " + criteria;
        }
        Connection con = DbPool.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(con, pst, null);
            List<Employer> employers = new ArrayList<>();
            int index = 0;
            while (rs != null && rs.next()) {
                index ++;
                Employer employer1 = new Employer();
                employer1.setName(rs.getString(1));
                employer1.setSex(rs.getString(2));
                employer1.setAge(Integer.toString(rs.getInt(3)));
                employer1.setCom_request(rs.getString(4));
                employer1.setLow_price(rs.getFloat(5));
                employer1.setHigh_price(rs.getFloat(6));
                employer1.setReg_time(rs.getString(7));
                employer1.setEmp_id(rs.getString(8));
                employer1.setIndex(employer1.getIndex()+index);
                employers.add(employer1);
            }
            return employers;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.releaseResourse(rs, pst, con);
        }
        return null;
    }


    public List<Employer> queryEmployerOther() {
        String sql = "SELECT name,sex,age,nation,address,edu,idcard,resaddress,phone,nowaddress,occ,workunit,low_price,high_price,fam_address,fam_people,comrequest,fam_area,fam_diet,fam_other,servaddress,emp_id from employer";
        Connection con = DbPool.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(con, pst, null);
            List<Employer> employers = new ArrayList<>();
            while (rs != null && rs.next()) {
                Employer employer1 = new Employer();
                employer1.setName(rs.getString(1));
                employer1.setSex(rs.getString(2));
                employer1.setAge(Integer.toString(rs.getInt(3)));
                employer1.setNation(rs.getString(4));
                employer1.setAddress(rs.getString(5));
                employer1.setEdu(rs.getString(6));
                employer1.setIdcard(rs.getString(7));
                employer1.setResaddress(rs.getString(8));
                employer1.setPhone(rs.getString(9));
                employer1.setNowaddress(rs.getString(10));
                employer1.setOcc(rs.getString(11));
                employer1.setWorkunit(rs.getString(12));
                employer1.setLow_price(rs.getFloat(13));
                employer1.setHigh_price(rs.getFloat(14));
                employer1.setFam_address(rs.getString(15));
                employer1.setFam_people(rs.getString(16));
                employer1.setCom_request(rs.getString(17));
                employer1.setFam_area(rs.getString(18));
                employer1.setFam_diet(rs.getString(19));
                employer1.setFam_other(rs.getString(20));
                employer1.setResaddress(rs.getString(21));
                employer1.setCom_id(rs.getString(22));
                employers.add(employer1);
            }
            return employers;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.releaseResourse(rs, pst, con);
        }
        return null;
    }

    public List<Employer> queryByNmae(String name) {
        String sql = "SELECT name,sex,age,nation,address,edu,idcard,resaddress,phone,nowaddress,occ,workunit,low_price,high_price,fam_address,fam_people,comrequest,fam_area,fam_diet,fam_other,servaddress,emp_id from employer where name = ?";
        Connection con = DbPool.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(con, pst, name);
            List<Employer> employers = new ArrayList<>();
            while (rs != null && rs.next()) {
                Employer employer1 = new Employer();
                employer1.setName(rs.getString(1));
                employer1.setSex(rs.getString(2));
                employer1.setAge(Integer.toString(rs.getInt(3)));
                employer1.setNation(rs.getString(4));
                employer1.setAddress(rs.getString(5));
                employer1.setEdu(rs.getString(6));
                employer1.setIdcard(rs.getString(7));
                employer1.setResaddress(rs.getString(8));
                employer1.setPhone(rs.getString(9));
                employer1.setNowaddress(rs.getString(10));
                employer1.setOcc(rs.getString(11));
                employer1.setWorkunit(rs.getString(12));
                employer1.setLow_price(rs.getFloat(13));
                employer1.setHigh_price(rs.getFloat(14));
                employer1.setFam_address(rs.getString(15));
                employer1.setFam_people(rs.getString(16));
                employer1.setCom_request(rs.getString(17));
                employer1.setFam_area(rs.getString(18));
                employer1.setFam_diet(rs.getString(19));
                employer1.setFam_other(rs.getString(20));
                employer1.setResaddress(rs.getString(21));
                employer1.setCom_id(rs.getString(22));
                employers.add(employer1);
            }
            return employers;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.releaseResourse(rs, pst, con);
        }
        return null;
    }

    //查询简易交易信息
    public List<QueryDeal> queryDeal(QueryDeal qd) {
        List<QueryDeal> queryDealList = new ArrayList<>();
        String empname = qd.getEmpname().trim();
        String workname = qd.getWorkname().trim();
        String regtime = qd.getRegtime().trim();
        String regtime1 = qd.getRegtime1().trim();
        String statu = qd.getStatu().trim();
        String sql = "SELECT  d.price,d.statue,d.employ_type,w.work_name,w.phone,e.name,e.phone,d.dealid FROM deal d,work w,employer e where d.emp_id = e.emp_id and d.work_id = w.work_id";
        if (!empname.isEmpty() && workname.isEmpty() && regtime.isEmpty() && regtime1.isEmpty() && statu.isEmpty()) {
            sql += " and e.name = '" + empname + "'";
        } else if (empname.isEmpty() && !workname.isEmpty() && regtime.isEmpty() && regtime1.isEmpty() && statu.isEmpty()) {
            sql += " and w.work_name = '" + workname + "'";
        } else if (empname.isEmpty() && workname.isEmpty() && !regtime.isEmpty() && !regtime1.isEmpty() && statu.isEmpty()) {
            sql += " and d.reg_time bewteen '" + regtime + "' and '" + regtime1 + "'";
        } else if (empname.isEmpty() && workname.isEmpty() && regtime.isEmpty() && regtime1.isEmpty() && !statu.isEmpty()) {
            sql += " and d.statue = '" + statu + "'";
        } else if (empname.isEmpty() && workname.isEmpty() && !regtime.isEmpty() && !regtime1.isEmpty() && !statu.isEmpty()) {
            sql += " and d.reg_time bewteen '" + regtime + "' and '" + regtime1 + "'";
            sql += " and d.statue = '" + statu + "'";
        } else if (empname.isEmpty() && !workname.isEmpty() && regtime.isEmpty() && regtime1.isEmpty() && !statu.isEmpty()) {
            sql += " and d.statue = '" + statu + "'";
            sql += " and w.work_name = '" + workname + "'";
        } else if (!empname.isEmpty() && workname.isEmpty() && regtime.isEmpty() && regtime1.isEmpty() && !statu.isEmpty()) {
            sql += " and d.statue = '" + statu + "'";
            sql += " and e.name = '" + empname + "'";
        } else if (!empname.isEmpty() && !workname.isEmpty() && regtime.isEmpty() && regtime1.isEmpty() && statu.isEmpty()) {
            sql += " and e.name = '" + empname + "'";
            sql += " and w.work_name = '" + workname + "'";
        } else if (!empname.isEmpty() && workname.isEmpty() && !regtime.isEmpty() && !regtime1.isEmpty() && statu.isEmpty()) {
            sql += " and e.name = '" + empname + "'";
            sql += " and d.reg_time bewteen '" + regtime + "' and '" + regtime1 + "'";
        } else if (!empname.isEmpty() && !workname.isEmpty() && !regtime.isEmpty() && !regtime1.isEmpty() && !statu.isEmpty()) {
            sql += " and e.name = '" + empname + "'";
            sql += " and w.work_name = '" + workname + "'";
            sql += " and d.reg_time bewteen '" + regtime + "' and '" + regtime1 + "'";
            sql += " and d.statue = '" + statu + "'";
        }
        Connection con = DbPool.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(con, pst, null);
            int index = 0;
            while (rs != null && rs.next()) {
                index ++;
                QueryDeal queryDeal = new QueryDeal();
                queryDeal.setPrice(rs.getString(1));
                queryDeal.setStatu(rs.getString(2));
                queryDeal.setWorktype(rs.getString(3));
                queryDeal.setWorkname(rs.getString(4));
                queryDeal.setWorkphone(rs.getString(5));
                queryDeal.setEmpname(rs.getString(6));
                queryDeal.setEmpphone(rs.getString(7));
                queryDeal.setDealid(rs.getInt(8));
                queryDeal.setIndex(queryDeal.getIndex() + index);
                queryDealList.add(queryDeal);
            }
            rs = null;
            return queryDealList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.releaseResourse(rs, pst, con);
        }
        return null;
    }

//查询详细交易信息
    public List<Object> queryDealAll(String dealid) {
        List<Object> list = new ArrayList<>();
        String sql = "SELECT e.name,e.sex,e.age,e.nation,e.address,e.edu,e.idcard,e.resaddress,e.phone,e.nowaddress,e.occ,e.workunit,e.low_price,e.high_price,e.fam_address,e.fam_people,d.employ_type,e.fam_area,e.fam_diet,e.fam_other,e.servaddress,d.agentid,d.reg_time,d.deal_time,d.statue,d.intro_price,d.other  FROM deal d,employer e where d.emp_id = e.emp_id and d.dealid = ?";
        Connection con = DbPool.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(con, pst, dealid);
            while (rs != null && rs.next()) {
                Employer employer1 = new Employer();
                employer1.setName(rs.getString(1));
                employer1.setSex(rs.getString(2));
                employer1.setAge(Integer.toString(rs.getInt(3)));
                employer1.setNation(rs.getString(4));
                employer1.setAddress(rs.getString(5));
                employer1.setEdu(rs.getString(6));
                employer1.setIdcard(rs.getString(7));
                employer1.setResaddress(rs.getString(8));
                employer1.setPhone(rs.getString(9));
                employer1.setNowaddress(rs.getString(10));
                employer1.setOcc(rs.getString(11));
                employer1.setWorkunit(rs.getString(12));
                employer1.setLow_price(rs.getFloat(13));
                employer1.setHigh_price(rs.getFloat(14));
                employer1.setFam_address(rs.getString(15));
                employer1.setFam_people(rs.getString(16));
                employer1.setCom_request(rs.getString(17));
                employer1.setFam_area(rs.getString(18));
                employer1.setFam_diet(rs.getString(19));
                employer1.setFam_other(rs.getString(20));
                employer1.setServaddress(rs.getString(21));
                Deal deal = new Deal();
                deal.setAgentid(rs.getInt(22));
                deal.setReg_time(rs.getString(23));
                deal.setDeal_time(rs.getString(24));
                deal.setStatue(rs.getString(25));
                deal.setIntro_price(rs.getInt(26));
                deal.setOther(rs.getString(27));
                list.add(employer1);
                list.add(deal);
            }
            rs = null;
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.releaseResourse(rs, pst, con);
        }
        return null;
    }

    public List<Object> updateDeal(String dealid) {
        List<Object> list = new ArrayList<>();
        String sql = "SELECT e.*,d.*,w.* FROM deal d,employer e,work w where d.emp_id = e.emp_id and d.work_id = w.work_id and d.dealid = ?";
        Connection con = DbPool.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(con, pst, dealid);
            while (rs != null && rs.next()) {
                Employer employer1 = new Employer();
                employer1.setName(rs.getString(2));
                employer1.setSex(rs.getString(3));
                employer1.setAge(Integer.toString(rs.getInt(4)));
                employer1.setNation(rs.getString(5));
                employer1.setAddress(rs.getString(6));
                employer1.setEdu(rs.getString(7));
                employer1.setIdcard(rs.getString(8));
                employer1.setWorkunit(rs.getString(9));
                employer1.setOcc(rs.getString(10));
                employer1.setWorkunit(rs.getString(12));
                employer1.setPhone(rs.getString(14));
                employer1.setNowaddress(rs.getString(15));
                employer1.setResaddress(rs.getString(16));
                employer1.setServaddress(rs.getString(17));
                employer1.setFam_address(rs.getString(18));
                employer1.setFam_people(rs.getString(19));
                employer1.setCom_request(rs.getString(20));
                employer1.setFam_area(rs.getString(22));
                employer1.setFam_diet(rs.getString(23));
                employer1.setFam_other(rs.getString(24));
                employer1.setHigh_price(rs.getFloat(27));
                employer1.setLow_price(rs.getFloat(28));
                Deal deal = new Deal();
                deal.setDealid(rs.getInt(31));
                deal.setAgentid(rs.getInt(32));
                deal.setReg_time(rs.getString(33));
                deal.setDeal_time(rs.getString(34));
                deal.setEmploy_type(rs.getString(37));
                deal.setStatue(rs.getString(35));
                deal.setPrice(Integer.valueOf(rs.getString(36)));
                deal.setIntro_price(rs.getInt(38));
                deal.setOther(rs.getString(43));
                deal.setEmp_id(Integer.valueOf(rs.getString(42)));
                Worker worker = new Worker();
                worker.setWork_id(rs.getString(44));
                worker.setCompany(rs.getString(74));
                worker.setWork_name(rs.getString(45));
                worker.setSex(rs.getString(46));
                worker.setPhone(rs.getString(53));
                worker.setIdcard(rs.getString(47));
                worker.setDate(rs.getString(48));
                worker.setAge(rs.getString(49));
                worker.setHigh(rs.getString(50));
                worker.setMphone(rs.getString(51));
                worker.setWork_type(rs.getString(52));
                worker.setWork_time(rs.getString(54));
                worker.setFlwa(rs.getString(55));
                worker.setStatus(rs.getString(62));
                list.add(employer1);
                list.add(deal);
                list.add(worker);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.releaseResourse(rs, pst, con);
        }
        return null;
    }


    public List<Employer> queryEmpAll(String emp_id){
        List<Employer> list = new ArrayList<>();
        String sql = "select * from employer where emp_id = ?";
        Connection con = DbPool.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(con, pst, emp_id);
            while (rs != null && rs.next()) {
                Employer employer1 = new Employer();
                employer1.setEmp_id(emp_id);
                employer1.setName(rs.getString(2));
                employer1.setSex(rs.getString(3));
                employer1.setAge(Integer.toString(rs.getInt(4)));
                employer1.setNation(rs.getString(5));
                employer1.setAddress(rs.getString(6));
                employer1.setEdu(rs.getString(7));
                employer1.setIdcard(rs.getString(8));
                employer1.setWorkunit(rs.getString(9));
                employer1.setOcc(rs.getString(10));
                employer1.setContractid(rs.getString(11));
                employer1.setContracttime(rs.getString(12));
                employer1.setMphone(rs.getString(13));
                employer1.setPhone(rs.getString(14));
                employer1.setNowaddress(rs.getString(15));
                employer1.setResaddress(rs.getString(16));
                employer1.setServaddress(rs.getString(17));
                employer1.setFam_address(rs.getString(18));
                employer1.setFam_people(rs.getString(19));
                employer1.setCom_request(rs.getString(20));
                employer1.setFam_content(rs.getString(21));
                employer1.setFam_area(rs.getString(22));
                employer1.setFam_diet(rs.getString(23));
                employer1.setFam_other(rs.getString(24));
                employer1.setAgent(rs.getString(25));
                employer1.setReg_time(rs.getString(26));
                employer1.setHigh_price(rs.getFloat(27));
                employer1.setLow_price(rs.getFloat(28));
                employer1.setRemark(rs.getString(29));
                employer1.setCom_id(rs.getString(30));
                list.add(employer1);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.releaseResourse(rs, pst, con);
        }
        return null;
    }

    public boolean updateEmp (Employer employer) {
        boolean result = false;
        PreparedStatement pst = null;
        String sql = "UPDATE employer SET name=?,sex=?,age=?,nation=?,address=?,edu=?,idcard=?,workunit=?,occ=?,contractid=?,contracttime=?,mphone=?,phone=?,resaddress=?,servaddress=?,fam_address=?,fam_people=?,comrequest=?,fam_area=?,fam_diet=?,fam_other=?,agent=?,reg_time=?,remark=? where emp_id=?";
        Connection con = DbPool.getConnection();
        try {
            con.setAutoCommit(false);
            pst = con.prepareStatement(sql);
            dao.execUpdate(con,pst,employer.getName(),employer.getSex(),employer.getAge(),employer.getNation(),employer.getAddress(),employer.getEdu(),employer.getIdcard(),employer.getWorkunit(),employer.getOcc(),employer.getContractid(),employer.getContracttime(),employer.getMphone(),employer.getPhone(),employer.getResaddress(),employer.getServaddress(),employer.getFam_address(),employer.getFam_people(),employer.getCom_request(),employer.getFam_area(),employer.getFam_diet(),employer.getFam_other(),employer.getAgent(),employer.getReg_time(),employer.getRemark(),employer.getEmp_id());
            con.commit();
            result = true;
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            dao.releaseResourse(null, pst, con);
        }
        return result;
    }


    public List<Worker> queryWorker(WorkerQuery wq) {
        List<Worker> queryWorkerList = new ArrayList<>();
        String name = wq.getName();
        String age1 = wq.getAge1();
        String age2 = wq.getAge2();
        String edu = wq.getEdu();
        String[] hobbit = wq.getHobbit();
        String[] luange = wq.getLuange();
        String luange1 = wq.getLuange1();
        String merry = wq.getMerry();
        String othermerry = wq.getOthermerry();
        String[] skill = wq.getSkill();
        String otherskill = wq.getOtherskill();
        String[] pic = wq.getPic();
        String statu = wq.getStatu();
        String otherstatu = wq.getOtherstatu();
        String worktime = wq.getWorktime();
        String sex = wq.getSex();
        String sql = "SELECT * from work";
        String criteria = "";
        if (!name.isEmpty()){
            criteria += " work_name ='"+name+"'";
        }
        if (!age1.isEmpty()&&!age2.isEmpty()){
            if (criteria.isEmpty()){
                criteria +=" age between "+age1+" and "+age2;
            }else {
                criteria +=" and age between "+age1+" and "+age2;
            }
        }
        if (edu!=null) {
            if (!edu.isEmpty()) {
                if (criteria.isEmpty()) {
                    criteria += " sautus = '" + edu + "'";
                } else {
                    criteria += " and sautus = '" + edu + "'";
                }
            }
        }
        if (statu!=null) {
            if (!statu.isEmpty()) {
                if (criteria.isEmpty()) {
                    criteria += " statu = '" + statu + "'";
                } else {
                    criteria += " and statu = '" + statu + "'";
                }
            }
        }
        if (!otherstatu.isEmpty()&&statu==null){
            if (criteria.isEmpty()){
                criteria +=" statu = '"+otherstatu+"'";
            }else {
                criteria +=" and statu = '"+otherstatu+"'";
            }
        }
        if (sex!=null) {
            if (!sex.isEmpty()) {
                if (criteria.isEmpty()) {
                    criteria += " sex = '" + sex + "'";
                } else {
                    criteria += " and sex = '" + sex + "'";
                }
            }
        }
        if (!worktime.isEmpty()){
            if (criteria.isEmpty()){
                criteria +=" work_time = '"+worktime+"'";
            }else {
                criteria +=" and work_time = '"+worktime+"'";
            }
        }
        if (luange!=null){
            if (criteria.isEmpty()){
                criteria +=" languge = '"+luange[0]+"'";
            }else {
                criteria +=" and languge = '"+luange[0]+"'";
            }
        }
        if (!luange1.isEmpty()){
            if (criteria.isEmpty()){
                criteria +=" languge = '"+luange1+"'";
            }else {
                criteria +=" and languge = '"+luange1+"'";
            }
        }
        if (merry!=null) {
            if (!merry.isEmpty()) {
                if (criteria.isEmpty()) {
                    criteria += " marry = '" + merry + "'";
                } else {
                    criteria += " and marry = '" + merry + "'";
                }
            }
        }
        if (!othermerry.isEmpty()&&merry==null){
            if (criteria.isEmpty()){
                criteria +=" marry = '"+othermerry+"'";
            }else {
                criteria +=" and marry = '"+othermerry+"'";
            }
        }
        if (skill!=null){
            if (criteria.isEmpty()){
                criteria +=" skill = '"+skill[0]+"'";
            }else {
                criteria +=" and skill = '"+skill[0]+"'";
            }
        }
        if (!otherskill.isEmpty()&&skill==null){
            if (criteria.isEmpty()){
                criteria +=" skill = '"+otherskill+"'";
            }else {
                criteria +=" and skill = '"+otherskill+"'";
            }
        }
        if (pic!=null){
            if (criteria.isEmpty()){
                criteria +=" pic_status = '"+pic[0]+"'";
            }else {
                criteria +=" and pic_status = '"+pic[0]+"'";
            }
        }
        if (!criteria.isEmpty()){
            sql += " where "+criteria;
        }
        Connection con = DbPool.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(con, pst, null);
            int index = 0;
            while (rs != null && rs.next()) {
                index ++;
                Worker worker = new Worker();
                worker.setWork_id(rs.getString(1));
                worker.setWork_name(rs.getString(2));
                worker.setSex(rs.getString(3));
                worker.setIdcard(rs.getString(4));
                worker.setDate(rs.getString(5));
                worker.setAge(rs.getString(6));
                worker.setHigh(rs.getString(7));
                worker.setMphone(rs.getString(8));
                worker.setWork_type(rs.getString(9));
                worker.setPhone(rs.getString(10));
                worker.setWork_time(rs.getString(11));
                worker.setFlwa(rs.getString(12));
                worker.setPic(rs.getString(13));
                worker.setAddress(rs.getString(14));
                worker.setNowaddress(rs.getString(15));
                worker.setBank_id(rs.getString(16));
                worker.setInsurid(rs.getString(17));
                worker.setLanguge(rs.getString(18));
                worker.setStatus(rs.getString(19));
                worker.setMarry(rs.getString(20));
                worker.setPic_status(rs.getString(21));
                worker.setHealth(rs.getString(22));
                worker.setHealth_time(rs.getString(23));
                worker.setSkill(rs.getString(24));
                worker.setSelf(rs.getString(25));
                worker.setTime_re(rs.getString(26));
                worker.setPrice_re(rs.getString(27));
                worker.setStay(rs.getString(28));
                worker.setBite(rs.getString(29));
                worker.setEnter_time(rs.getString(30));
                worker.setCompany(rs.getString(31));
                worker.setStatu(rs.getString(32));
                worker.setIndex(worker.getIndex()+index);
                queryWorkerList.add(worker);
            }
            rs = null;
            return queryWorkerList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.releaseResourse(rs, pst, con);
        }
        return null;
    }


    public List<Recharge> queryRecharge(){
        List<Recharge> list = new ArrayList<>();
        String sql = "SELECT  DISTINCT c.company_name,c.company_account,r.cash_amount,r.cash_money,r.cash_all,r.cash_balabce,rc.operator,rc.record,c.company_id from company c,recharge r,rechargerecord rc where c.company_id = r.company_id and c.company_id = rc.recompany_id";
        Connection con = DbPool.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(con, pst, null);
            int index = 0;
            while (rs != null && rs.next()) {
                index ++;
                Recharge recharge = new Recharge();
                recharge.setCompany_name(rs.getString(1));
                recharge.setCompany_account((rs.getString(2)));
                recharge.setCash_amount(rs.getString(3));
                recharge.setCash_money(rs.getString(4));
                recharge.setCash_all(rs.getString(5));
                recharge.setCash_balabce(rs.getString(6));
                recharge.setOperator(rs.getString(7));
                recharge.setRecord(rs.getString(8));
                recharge.setCompany_id(rs.getString(9));
                recharge.setIndex(index);
                list.add(recharge);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.releaseResourse(rs, pst, con);
        }
        return null;
    }


    public List<QueryCash> queryCash(){
        List<QueryCash> list = new ArrayList<>();
        String sql = "SELECT  c.company_name,c.company_account,ca.cash_time,ca.cash_price  from company c,cash ca where c.company_id = ca.company_id ";
        Connection con = DbPool.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(con, pst, null);
            int index = 0;
            while (rs != null && rs.next()) {
                index ++;
                QueryCash qc = new QueryCash();
                qc.setCompany_name(rs.getString(1));
                qc.setCompany_aacount(rs.getString(2));
                qc.setCash_time(rs.getString(3));
                qc.setCash_price(rs.getString(4));
                qc.setIndex(index);
                list.add(qc);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.releaseResourse(rs, pst, con);
        }
        return null;
    }

    public List<QueryCash> queryCashByParam(QueryCash queryCash){
        List<QueryCash> list = new ArrayList<>();
        String sql = "SELECT  c.company_name,c.company_account,ca.cash_time,ca.cash_price  from company c,cash ca where c.company_id = ca.company_id ";
        String carteria = "";
        if (!queryCash.getCompany_name().trim().isEmpty()){
            carteria += " c.company_name = '"+queryCash.getCompany_name().trim()+"'";
        }
        if (!queryCash.getCompany_aacount().trim().isEmpty()){
            if (carteria.isEmpty()){
                carteria += " c.company_account = '"+queryCash.getCompany_aacount().trim()+"'";
            }else {
                carteria += " and c.company_account = '"+queryCash.getCompany_aacount().trim()+"'";
            }
        }
        if (!queryCash.getDate().trim().isEmpty()&&!queryCash.getDate1().trim().isEmpty()){
            if (carteria.isEmpty()){
                carteria += " ca.cash_time between '"+queryCash.getDate().trim()+"' and '"+queryCash.getDate1().trim()+"'";
            }else {
                carteria += " and ca.cash_time between '"+queryCash.getDate().trim()+"' and '"+queryCash.getDate1().trim()+"'";
            }
        }
        if (!carteria.isEmpty()){
            sql += " and "+carteria;
        }
        Connection con = DbPool.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(con, pst, null);
            int index = 0;
            while (rs != null && rs.next()) {
                index ++;
                QueryCash qc = new QueryCash();
                qc.setCompany_name(rs.getString(1));
                qc.setCompany_aacount(rs.getString(2));
                qc.setCash_time(rs.getString(3));
                qc.setCash_price(rs.getString(4));
                qc.setIndex(index);
                list.add(qc);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.releaseResourse(rs, pst, con);
        }
        return null;
    }


    public List<Recharge> queryRechargeByParam(Recharge recharge){
        List<Recharge> list = new ArrayList<>();
        String sql = "SELECT  DISTINCT c.company_name,c.company_account,r.cash_amount,r.cash_money,r.cash_all,r.cash_balabce,rc.operator,rc.record,c.company_id from company c,recharge r,rechargerecord rc where c.company_id = r.company_id and c.company_id = rc.recompany_id";
        String carteria = "";
        if (!recharge.getCompany_name().trim().isEmpty()){
            carteria += " c.company_name = '"+recharge.getCompany_name().trim()+"'";
        }
        if (!recharge.getCompany_account().trim().isEmpty()){
            if (carteria.isEmpty()){
                carteria += " c.company_account = '"+recharge.getCompany_account().trim()+"'";
            }else {
                carteria += " and c.company_account = '"+recharge.getCompany_account().trim()+"'";
            }
        }
        if (!carteria.isEmpty()){
            sql += " and "+carteria;
        }
        Connection con = DbPool.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(con, pst, null);
            int index = 0;
            while (rs != null && rs.next()) {
                index ++;
                Recharge recharge1 = new Recharge();
                recharge1.setCompany_name(rs.getString(1));
                recharge1.setCompany_account((rs.getString(2)));
                recharge1.setCash_amount(rs.getString(3));
                recharge1.setCash_money(rs.getString(4));
                recharge1.setCash_all(rs.getString(5));
                recharge1.setCash_balabce(rs.getString(6));
                recharge1.setOperator(rs.getString(7));
                recharge1.setRecord(rs.getString(8));
                recharge1.setCompany_id(rs.getString(9));
                recharge1.setIndex(index);
                list.add(recharge1);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dao.releaseResourse(rs, pst, con);
        }
        return null;
    }
}
