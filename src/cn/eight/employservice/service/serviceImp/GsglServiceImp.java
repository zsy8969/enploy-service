package cn.eight.employservice.service.serviceImp;

import cn.eight.employservice.dao.GsglDao;
import cn.eight.employservice.pojo.Company;
import cn.eight.employservice.service.GsglService;

import java.util.List;

/**
 * @author 瞿琮
 * @create 2020-03-16 17:06
 */
public class GsglServiceImp implements GsglService {

    private GsglDao gsglDao=new GsglDao();

    @Override
    public boolean addCompany(Company company) {
        return gsglDao.addCompany(company);
    }

    @Override
    public List<Company> queryAllCompany(int pageNow, int pageSize) {
        return gsglDao.queryAllCompany(pageNow,pageSize);
    }

    //查询总记录数
    @Override
    public int findTotalRecord(String company_account, String company_name) {
        return gsglDao.totalRecord(company_account,company_name);
    }



    //按条件查询公司
    @Override
    public List<Company> queryCompanyByCritria(String company_account, String company_name,int pageNow,int pageSize) {
        return gsglDao.queryCompanyByCritria(company_account,company_name,pageNow,pageSize);
    }

    //删除记录
    @Override
    public boolean removeCompany(String[] ids) {
        return gsglDao.removeCompany(ids);
    }

    @Override
    public boolean modCompany(Company company) {
        return gsglDao.modCompany(company);
    }

    //按编号查公司
    @Override
    public Company findCompanyById(int id) {
        return gsglDao.findCompanyById(id);
    }


}
