package cn.eight.employservice.pojo;

import java.util.Date;

/**
 * @author 瞿琮
 * @create 2020-03-19 10:10
 */
public class Xfgl {
   private Integer consume_id;
   private Integer company_id;
   private String company_name;
   private Float consume_money;
   private String consume_time;
   private Integer consume_typeInt;
   private String consume_typeStr;

    public Xfgl() {
    }

    public Xfgl(Integer consume_id, Integer company_id, Float consume_money, String consume_time, Integer consume_typeInt) {
        this.consume_id = consume_id;
        this.company_id = company_id;
        this.consume_money = consume_money;
        this.consume_time = consume_time;
        this.consume_typeInt = consume_typeInt;
    }

    public Integer getConsume_id() {
        return consume_id;
    }

    public void setConsume_id(Integer consume_id) {
        this.consume_id = consume_id;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public Float getConsume_money() {
        return consume_money;
    }

    public void setConsume_money(Float consume_money) {
        this.consume_money = consume_money;
    }

    public String getConsume_time() {
        return consume_time;
    }

    public void setConsume_time(String consume_time) {
        this.consume_time = consume_time;
    }

    public Integer getConsume_typeInt() {
        return consume_typeInt;
    }

    public void setConsume_typeInt(Integer consume_typeInt) {
        this.consume_typeInt = consume_typeInt;
    }

    public String getConsume_typeStr() {
        return consume_typeStr;
    }

    public void setConsume_typeStr(String consume_typeStr) {
        this.consume_typeStr = consume_typeStr;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    //通过类型数字判断消费类型
    public void typeInttoStr(Xfgl xfgl){
        if (xfgl.getConsume_typeInt()==1){
            xfgl.setConsume_typeStr("录入雇主");
        }else if(xfgl.getConsume_typeInt()==2){
            xfgl.setConsume_typeStr("录入工人");
        }
    }
}
