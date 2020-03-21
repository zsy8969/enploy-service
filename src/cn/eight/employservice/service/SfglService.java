package cn.eight.employservice.service;

import cn.eight.employservice.pojo.Deal;
import cn.eight.employservice.pojo.Employer;
import cn.eight.employservice.pojo.Work;
import cn.eight.employservice.pojo.Xfgl;

import java.util.List;

/**
 * @author 瞿琮
 * @create 2020-03-21 10:43
 */
public interface SfglService {
    //查询所有
    List<Deal> queryAll(int pageNow,int pageSize);
    //得到总记录数
    int findTotalRecord(String startTime,String endTime);
    //按编号得到名称
    String findNameById(int id,String type);
    //按时间查询
    List<Deal> queryByTime(String startTime, String endTime, int pageNow, int pageSize);
    //通过交易编号得到交易记录
    Deal findDealBydealId(Integer id);
    //通过雇主编号查询雇主信息
    Employer findEmployerById(Integer emp_id);
    //通过工人编号查询工人信息
    Work findWorkById(Integer work_id);
}
