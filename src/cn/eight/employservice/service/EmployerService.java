package cn.eight.employservice.service;

import cn.eight.employservice.pojo.*;

import java.util.List;

public interface EmployerService {
    boolean addEmployer(Employer employer);
    List<Employer> queryEmployer(Employer employer);
    List<Employer> queryEmployerOther();
    List<Employer> queryByName(String name);
    boolean addDeal(Deal deal);
    boolean updateDeal(Deal deal);
    List<QueryDeal> queryDeal(QueryDeal qd);
    List<Object> queryDealAll(String dealid);
    List<Object> updateDeal(String dealid);
    List<Employer> queryEmpAll(String emp_id);
    boolean updateEmp(Employer employer);
    List<Worker> queryWorker(WorkerQuery wq);
    List<Recharge> queryRecharge();
    boolean addRechargeRecord(RechargeRocard rocard);
    List<QueryCash> queryCash();
    List<QueryCash> queryCashByParam(QueryCash queryCash);
    List<Recharge> queryRechargeByParam(Recharge recharge);
}
