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
}
