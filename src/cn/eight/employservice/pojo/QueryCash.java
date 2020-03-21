package cn.eight.employservice.pojo;

public class QueryCash {
    private String  company_name;
    private String  company_aacount;
    private String  cash_price;
    private String  cash_time;
    private Integer index = 0  ;
    private String date;
    private String date1;

    public QueryCash(String company_name, String company_aacount, String date, String date1) {
        this.company_name = company_name;
        this.company_aacount = company_aacount;
        this.date = date;
        this.date1 = date1;
    }

    public QueryCash() {
    }

    public QueryCash(String company_name, String company_aacount, String cash_price, String cash_time, Integer index) {
        this.company_name = company_name;
        this.company_aacount = company_aacount;
        this.cash_price = cash_price;
        this.cash_time = cash_time;
        this.index = index;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_aacount() {
        return company_aacount;
    }

    public void setCompany_aacount(String company_aacount) {
        this.company_aacount = company_aacount;
    }

    public String getCash_price() {
        return cash_price;
    }

    public void setCash_price(String cash_price) {
        this.cash_price = cash_price;
    }

    public String getCash_time() {
        return cash_time;
    }

    public void setCash_time(String cash_time) {
        this.cash_time = cash_time;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
