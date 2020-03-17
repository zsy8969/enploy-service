package cn.eight.employservice.service;

import cn.eight.employservice.pojo.Company;

import java.util.List;

/**
 * @author 瞿琮
 * @create 2020-03-16 17:06
 */
public interface GsglService {
    //新增
    boolean addCompany(Company company);
    //查询所有公司
    List<Company> queryAllCompany(int pageNow,int pageSize);
    //记录总数量
    int findTotalRecord();
    //按条件查询公司
    List<Company> queryCompanyByCritria(String company_account,String company_name);
    //删除记录
    boolean removeCompany(String[] ids);
    //修改记录
    boolean modCompany(Company company);
}
