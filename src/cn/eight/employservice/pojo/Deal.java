package cn.eight.employservice.pojo;

import java.util.Date;

/**
 * @author 瞿琮
 * @create 2020-03-16 11:53
 */
public class Deal {
    //交易编号
    private Integer dealId;
    //公司编号
    private Integer companyId;
    //雇主编号
    private Integer employerId;
    //员工编号
    private Integer workId;
    //经办人编号
    private Integer agentId;
    //登记时间
    private String regTime;
    //交易有效期
    private String dealValidity;
    //状态
    private String state;
    //工资
    private Integer wage;
    //雇佣类型
    private String hireType;
    //介绍费
    private Integer referralFee;
    //成交日期
    private String fixDate;

    //公司名称，在交易表中没有公司名称，设一个公司名称参数，调用Company类中的方法找到名称并通过set方法放进来
    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    //员工名称
    private String workName;

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    //客户名称
    private String employerName;

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public Deal() {
    }

    public Deal(Integer dealId, Integer companyId, Integer employerId, Integer workId, Integer agentId, String regTime, String dealValidity, String state, Integer wage, String hireType, Integer referralFee, String fixDate) {
        this.dealId = dealId;
        this.companyId = companyId;
        this.employerId = employerId;
        this.workId = workId;
        this.agentId = agentId;
        this.regTime = regTime;
        this.dealValidity = dealValidity;
        this.state = state;
        this.wage = wage;
        this.hireType = hireType;
        this.referralFee = referralFee;
        this.fixDate = fixDate;
    }

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getEmployerId() {
        return employerId;
    }

    public void setEmployerId(Integer employerId) {
        this.employerId = employerId;
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public String getDealValidity() {
        return dealValidity;
    }

    public void setDealValidity(String dealValidity) {
        this.dealValidity = dealValidity;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getWage() {
        return wage;
    }

    public void setWage(Integer wage) {
        this.wage = wage;
    }

    public String getHireType() {
        return hireType;
    }

    public void setHireType(String hireType) {
        this.hireType = hireType;
    }

    public Integer getReferralFee() {
        return referralFee;
    }

    public void setReferralFee(Integer referralFee) {
        this.referralFee = referralFee;
    }

    public String getFixDate() {
        return fixDate;
    }

    public void setFixDate(String fixDate) {
        this.fixDate = fixDate;
    }
}
