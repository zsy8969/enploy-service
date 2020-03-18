package cn.eight.employservice.service;

import cn.eight.employservice.pojo.Sjzd;

import java.util.List;

/**
 * @author 瞿琮
 * @create 2020-03-18 10:37
 */
public interface SjzdService {
    //查询所有记录
    List<Sjzd> queryAllData(int pageNow,int pageSize);
    //查询总记录条数
    int findTotalRecord();
    //按条件查询
    List<Sjzd> queryDataByCritria(int sortInt);
    //新增记录
    boolean addData(Sjzd date);
    //删除记录
    boolean removeData(String[] ids);
    //修改数据
    boolean modData(Sjzd datas);
}
