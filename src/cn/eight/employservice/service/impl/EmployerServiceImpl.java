package cn.eight.employservice.service.impl;

import cn.eight.employservice.dao.EmployerDao;
import cn.eight.employservice.pojo.Employer;
import cn.eight.employservice.service.EmployerService;

public class EmployerServiceImpl implements EmployerService {
    EmployerDao dao = new EmployerDao();
    @Override
    public boolean addEmployer(Employer employer) {
        boolean result = dao.insertEmployer(employer);
        return result;
    }
}
