package cn.eight.employservice.service;

import cn.eight.employservice.pojo.Xfgl;

import java.util.List;

/**
 * @author 瞿琮
 * @create 2020-03-19 10:21
 */
public interface XfglService {
    //查询所有
    List<Xfgl> queryAll(int pageNow,int pageSize);
    //得到总记录数
    int totalRecord(String startTime,String endTime);
    //按时间查询
    List<Xfgl> queryByTime(String startTime,String endTime,int pageNow,int pageSize);
}
