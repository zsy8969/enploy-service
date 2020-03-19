package cn.eight.employservice.service.serviceImp;

import cn.eight.employservice.dao.SjzdDao;
import cn.eight.employservice.pojo.Sjzd;
import cn.eight.employservice.service.SjzdService;

import java.util.List;

/**
 * @author 瞿琮
 * @create 2020-03-18 10:38
 */
public class SjzdServiceImp implements SjzdService {

    private SjzdDao sjzdDao= new SjzdDao();

    //查询所有数据
    @Override
    public List<Sjzd> queryAllData(int pageNow,int pageSize) {
        return sjzdDao.queryAllData(pageNow,pageSize);
    }

    @Override
    public int findTotalRecord(Integer sortInt) {
        return sjzdDao.totalRecord(sortInt);
    }

//    @Override
//    public int findTotalRecordByCritria(int sortInt) {
//        return sjzdDao.totalRecordByCritria(sortInt);
//    }

    @Override
    public List<Sjzd> queryDataByCritria(int sortInt,int pageNow,int pageSize) {
        return sjzdDao.queryDataByCritria(sortInt,pageNow,pageSize);
    }

    @Override
    public boolean addData(Sjzd date) {
        return sjzdDao.addData(date);
    }

    @Override
    public boolean removeData(String[] ids) {
        return sjzdDao.removeData(ids);
    }

    @Override
    public boolean modData(Sjzd datas) {
        return sjzdDao.modData(datas);
    }
}
