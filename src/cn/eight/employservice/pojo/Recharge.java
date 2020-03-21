package cn.eight.employservice.pojo;

public class Recharge {
    private String company_name;
    private String  company_account;
    private String  cash_amount;
    private String  cash_money;
    private String  cash_all;
    private String  cash_balabce;
    private String  operator;
    private String  record;
    private Integer   index = 0;
    private String company_id;

    public Recharge(String company_name, String company_account) {
        this.company_name = company_name;
        this.company_account = company_account;
    }

    public Recharge() {
    }

    public Recharge(String company_name, String company_account, String cash_amount, String cash_money, String cash_all, String cash_balabce, String operator, String record, Integer index) {
        this.company_name = company_name;
        this.company_account = company_account;
        this.cash_amount = cash_amount;
        this.cash_money = cash_money;
        this.cash_all = cash_all;
        this.cash_balabce = cash_balabce;
        this.operator = operator;
        this.record = record;
        this.index = index;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_account() {
        return company_account;
    }

    public void setCompany_account(String company_account) {
        this.company_account = company_account;
    }

    public String getCash_amount() {
        return cash_amount;
    }

    public void setCash_amount(String cash_amount) {
        this.cash_amount = cash_amount;
    }

    public String getCash_money() {
        return cash_money;
    }

    public void setCash_money(String cash_money) {
        this.cash_money = cash_money;
    }

    public String getCash_all() {
        return cash_all;
    }

    public void setCash_all(String cash_all) {
        this.cash_all = cash_all;
    }

    public String getCash_balabce() {
        return cash_balabce;
    }

    public void setCash_balabce(String cash_balabce) {
        this.cash_balabce = cash_balabce;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
