package cn.eight.employservice.service.serviceImp;

import cn.eight.employservice.dao.XfglDao;
import cn.eight.employservice.pojo.Xfgl;
import cn.eight.employservice.service.XfglService;

import java.util.List;

/**
 * @author 瞿琮
 * @create 2020-03-19 10:22
 */
public class XfglServiceImp implements XfglService {

    private XfglDao xfglDao = new XfglDao();

    @Override
    public List<Xfgl> queryAll(int pageNow,int pageSize) {

        return xfglDao.queryAll(pageNow,pageSize);
    }

    @Override
    public int totalRecord(String startTime,String endTime) {
        return xfglDao.totalRecord(startTime,endTime);
    }

    @Override
    public List<Xfgl> queryByTime(String startTime, String endTime,int pageNow,int pageSize) {
        return xfglDao.queryByTime(startTime,endTime,pageNow,pageSize);
    }
}
