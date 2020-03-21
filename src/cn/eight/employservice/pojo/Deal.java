package cn.eight.employservice.pojo;

public class Deal {
    private Integer dealid;
    private Integer agentid;
    private Integer price;
    private Integer intro_price;
    private Integer company_id;
    private Integer work_id;
    private Integer emp_id;
    private String reg_time;
    private String dealtime;
    private String statue;
    private String employ_type;
    private String deal_time;
    private String other;

    public Deal() {
    }

    public Deal(Integer dealid, Integer agentid, Integer price, Integer intro_price, Integer company_id, Integer work_id, Integer emp_id, String reg_time, String dealtime, String statue, String employ_type, String deal_time,String other) {
        this.dealid = dealid;
        this.agentid = agentid;
        this.price = price;
        this.intro_price = intro_price;
        this.company_id = company_id;
        this.work_id = work_id;
        this.emp_id = emp_id;
        this.reg_time = reg_time;
        this.dealtime = dealtime;
        this.statue = statue;
        this.employ_type = employ_type;
        this.deal_time = deal_time;
        this.other = other;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public Integer getDealid() {
        return dealid;
    }

    public void setDealid(Integer dealid) {
        this.dealid = dealid;
    }

    public Integer getAgentid() {
        return agentid;
    }

    public void setAgentid(Integer agentid) {
        this.agentid = agentid;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getIntro_price() {
        return intro_price;
    }

    public void setIntro_price(Integer intro_price) {
        this.intro_price = intro_price;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public Integer getWork_id() {
        return work_id;
    }

    public void setWork_id(Integer work_id) {
        this.work_id = work_id;
    }

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public String getReg_time() {
        return reg_time;
    }

    public void setReg_time(String reg_time) {
        this.reg_time = reg_time;
    }

    public String getDealtime() {
        return dealtime;
    }

    public void setDealtime(String dealtime) {
        this.dealtime = dealtime;
    }

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }

    public String getEmploy_type() {
        return employ_type;
    }

    public void setEmploy_type(String employ_type) {
        this.employ_type = employ_type;
    }

    public String getDeal_time() {
        return deal_time;
    }

    public void setDeal_time(String deal_time) {
        this.deal_time = deal_time;
    }
}
