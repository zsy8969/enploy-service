package cn.eight.employservice.pojo;

public class RechargeRocard {
    private String record;
    private String recharge_money;
    private String operator;
    private String recharge_time;
    private String company_id;

    public RechargeRocard(String record, String recharge_money, String operator, String recharge_time,String company_id) {
        this.record = record;
        this.recharge_money = recharge_money;
        this.operator = operator;
        this.recharge_time = recharge_time;
        this.company_id = company_id;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getRecharge_money() {
        return recharge_money;
    }

    public void setRecharge_money(String recharge_money) {
        this.recharge_money = recharge_money;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getRecharge_time() {
        return recharge_time;
    }

    public void setRecharge_time(String recharge_time) {
        this.recharge_time = recharge_time;
    }
}