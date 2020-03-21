package cn.eight.employservice.service.serviceImp;

import cn.eight.employservice.dao.SfglDao;
import cn.eight.employservice.pojo.Deal;
import cn.eight.employservice.pojo.Employer;
import cn.eight.employservice.pojo.Work;
import cn.eight.employservice.service.SfglService;

import java.util.List;

/**
 * @author 瞿琮
 * @create 2020-03-21 10:50
 */
public class SfglServiceImp implements SfglService {
    SfglDao sfglDao=new SfglDao();

    @Override
    public List<Deal> queryAll(int pageNow, int pageSize) {
        return sfglDao.queryAll(pageNow,pageSize);
    }


    @Override
    public int findTotalRecord(String startTime, String endTime) {
        return sfglDao.totalRecord(startTime,endTime);
    }

    @Override
    public String findNameById(int id,String type) {
        return sfglDao.findNameById(id,type);
    }

    @Override
    public List<Deal> queryByTime(String startTime, String endTime, int pageNow, int pageSize) {
        return sfglDao.queryByTime(startTime,endTime,pageNow,pageSize);
    }

    @Override
    public Deal findDealBydealId(Integer id) {
        return sfglDao.findDealBydealId(id);
    }

    @Override
    public Employer findEmployerById(Integer emp_id) {
        return sfglDao.findEmployerById(emp_id);
    }

    @Override
    public Work findWorkById(Integer work_id) {
        return sfglDao.findWorkById(work_id);
    }
}
