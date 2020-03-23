package cn.eight.employservice.pojo;

public class QueryDeal {
    private String empname;
    private String regtime;
    private String regtime1;
    private String workname;
    private String statu;
    private String empphone;
    private String workphone;
    private String price;
    private String worktype;
    private String emp_id;
    private String work_id;
    private Integer index = 0;
    private Integer dealid;

    public QueryDeal() {
    }

    public QueryDeal(String empname, String regtime, String regtime1, String workname, String statu) {
        this.empname = empname;
        this.regtime = regtime;
        this.regtime1 = regtime1;
        this.workname = workname;
        this.statu = statu;
    }

    public Integer getDealid() {
        return dealid;
    }

    public void setDealid(Integer dealid) {
        this.dealid = dealid;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getWork_id() {
        return work_id;
    }

    public void setWork_id(String work_id) {
        this.work_id = work_id;
    }

    public String getEmpphone() {
        return empphone;
    }

    public void setEmpphone(String empphone) {
        this.empphone = empphone;
    }

    public String getWorkphone() {
        return workphone;
    }

    public void setWorkphone(String workphone) {
        this.workphone = workphone;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getWorktype() {
        return worktype;
    }

    public void setWorktype(String worktype) {
        this.worktype = worktype;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getRegtime() {
        return regtime;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }

    public String getRegtime1() {
        return regtime1;
    }

    public void setRegtime1(String regtime1) {
        this.regtime1 = regtime1;
    }

    public String getWorkname() {
        return workname;
    }

    public void setWorkname(String workname) {
        this.workname = workname;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }
}
