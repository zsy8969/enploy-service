package cn.eight.employservice.pojo;

import cn.eight.employservice.service.GsglService;
import cn.eight.employservice.service.serviceImp.GsglServiceImp;

/**
 * @author 瞿琮
 * @create 2020-03-16 16:55
 */
public class Company {
    private Integer company_id;
    private String company_account;
    private String company_name;
    private String company_intro;

    public Company() {
    }

    public Company(Integer company_id, String company_account, String company_name, String company_intro) {
        this.company_id = company_id;
        this.company_account = company_account;
        this.company_name = company_name;
        this.company_intro = company_intro;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public String getCompany_account() {
        return company_account;
    }

    public void setCompany_account(String company_account) {
        this.company_account = company_account;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_intro() {
        return company_intro;
    }

    public void setCompany_intro(String company_intro) {
        this.company_intro = company_intro;
    }

    //通过公司编号查询公司名称
    public Company findCompanyById(int company_id){
        GsglService gsglService=new GsglServiceImp();
        Company companyById = gsglService.findCompanyById(company_id);
        return companyById;
    }


    }
