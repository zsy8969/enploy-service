package cn.eight.employservice.service;

import cn.eight.employservice.pojo.Sjzd;

import java.util.List;

/**
 * @author 瞿琮
 * @create 2020-03-18 10:37
 */
public interface SjzdService {
    List<Sjzd> queryAllData(int pageNow,int pageSize);
}
