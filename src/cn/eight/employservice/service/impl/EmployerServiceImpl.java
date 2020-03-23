package cn.eight.employservice.service.impl;

import cn.eight.employservice.pojo.*;
import cn.eight.employservice.dao.EmployerDao;
import cn.eight.employservice.service.EmployerService;

import java.util.List;

public class EmployerServiceImpl implements EmployerService {
    EmployerDao dao = new EmployerDao();
    @Override
    public boolean addEmployer(Employer employer) {
        boolean result = dao.insertEmployer(employer);
        return result;
    }

    @Override
    public List<Employer> queryEmployer(Employer employer) {
        List<Employer> employers = dao.queryEmployer(employer);
        return employers;
    }

    @Override
    public List<Employer> queryEmployerOther() {
        return dao.queryEmployerOther();
    }

    @Override
    public List<Employer> queryByName(String name) {
        List<Employer> employers = dao.queryByNmae(name);
        return employers;
    }

    @Override
    public boolean addDeal(Deal deal) {
        return dao.insertDeal(deal);
    }

    @Override
    public boolean updateDeal(Deal deal) {
        return dao.updateDeal(deal);
    }

    @Override
    public List<QueryDeal> queryDeal(QueryDeal qd) {
        return dao.queryDeal(qd);
    }

    @Override
    public List<Object> queryDealAll(String dealid) {
        List<Object> list = dao.queryDealAll(dealid);
        return list;
    }

    @Override
    public List<Object> updateDeal(String dealid) {
        return dao.updateDeal(dealid);
    }

    @Override
    public List<Employer> queryEmpAll(String emp_id) {
        return dao.queryEmpAll(emp_id);
    }

    @Override
    public boolean updateEmp(Employer employer) {
        return dao.updateEmp(employer);
    }

    @Override
    public List<Worker> queryWorker(WorkerQuery wq) {
        return dao.queryWorker(wq);
    }

    @Override
    public List<Recharge> queryRecharge() {
        return dao.queryRecharge();
    }

    @Override
    public boolean addRechargeRecord(RechargeRocard rocard) {
        return dao.addRechargeRecord(rocard);
    }

    @Override
    public List<QueryCash> queryCash() {
        return dao.queryCash();
    }

    @Override
    public List<QueryCash> queryCashByParam(QueryCash queryCash) {
        return dao.queryCashByParam(queryCash);
    }

    @Override
    public List<Recharge> queryRechargeByParam(Recharge recharge) {
        return dao.queryRechargeByParam(recharge);
    }
}
