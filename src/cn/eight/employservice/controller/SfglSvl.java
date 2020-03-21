package cn.eight.employservice.controller;

import cn.eight.employservice.pojo.Company;
import cn.eight.employservice.pojo.Deal;
import cn.eight.employservice.pojo.Employer;
import cn.eight.employservice.pojo.Work;
import cn.eight.employservice.service.SfglService;
import cn.eight.employservice.service.serviceImp.SfglServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 瞿琮
 * @create 2020-03-21 10:39
 */
@WebServlet(urlPatterns = "/houtai/sfglSvl",name = "SfglServlet",initParams = {@WebInitParam(name = "pageSize",value = "2")})
public class SfglSvl extends HttpServlet {
    SfglService sfglService=new SfglServiceImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reqType = request.getParameter("reqType");
        if (reqType.equals("queryAll")){
            queryAll(request,response,-1);
        }else if (reqType.equals("queryByCritria")){
            queryByTime(request,response);
        }else if (reqType.equals("findOrder")){
            findOrder(request,response);
        }
    }

    //查看订单
    private void findOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        int dealId = Integer.valueOf(request.getParameter("dealId"));
        Deal dealById = sfglService.findDealBydealId(dealId);//通过交易编号得到交易记录
        Company company=new Company();
        Company companyById = company.findCompanyById(dealById.getCompanyId());
        dealById.setCompanyName(companyById.getCompany_name());//得到了公司名称

        Employer employerById = sfglService.findEmployerById(dealById.getEmployerId());
        Work workById = sfglService.findWorkById(dealById.getWorkId());

        if (employerById!=null&&workById!=null&&dealById!=null){
            request.setAttribute("employer",employerById);
            request.setAttribute("work",workById);
            request.setAttribute("deal",dealById);
            request.getRequestDispatcher("ny/cwgl/ckdd.jsp").forward(request,response);
        }

    }

    private void queryByTime(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        int pageSize = Integer.valueOf(getServletConfig().getInitParameter("pageSize"));
        String startTime = request.getParameter("searchName2");
        String endTime = request.getParameter("searchName4");
        int pageNow=Integer.valueOf(request.getParameter("pageNow"));
        if (pageNow<1){
            pageNow=1;
        }

        List<Deal> dealListByTime = sfglService.queryByTime(startTime, endTime, pageNow, pageSize);
        float allMoney=0; //总额
        if (!dealListByTime.isEmpty()){
            for (int i = 0; i < dealListByTime.size(); i++) {
                Deal deal=dealListByTime.get(i);
                Integer companyId = deal.getCompanyId();//得到公司编号
                Company company=new Company();
                Company companyById = company.findCompanyById(companyId);//通过公司编号得到公司对象
                deal.setCompanyName(companyById.getCompany_name());//从返回的公司对象中得到名称

                //改进了，得到工人名称
                Integer workId =deal.getWorkId();
                String workName = sfglService.findNameById(workId, "work");
                deal.setWorkName(workName);
                //得到客户名称
                Integer employerId = deal.getEmployerId();
                String employerName = sfglService.findNameById(employerId, "employer");
                deal.setEmployerName(employerName);
                allMoney += dealListByTime.get(i).getReferralFee();
            }
        }


        int totalRecord = sfglService.findTotalRecord(startTime,endTime);
        int totalPages;
        if (totalRecord%pageSize==0){
            totalPages=totalRecord/pageSize;
        }else {
            totalPages=totalRecord/pageSize+1;
        }

        request.setAttribute("dealListByTime",dealListByTime);//查询的数据
        request.setAttribute("zonge",allMoney);//消费总额
        request.setAttribute("pageNow",pageNow);//当前页数
        request.setAttribute("totalRecord",totalRecord);//总记录数
        request.setAttribute("totalPages",totalPages);//总页数
        //查询条件
        request.setAttribute("startTime",startTime);
        request.setAttribute("endTime",endTime);
        request.getRequestDispatcher("ny/cwgl/sfgl_cx.jsp").forward(request,response);



    }


    //查询所有记录并分页展示
    private void queryAll(HttpServletRequest request, HttpServletResponse response,int update_page) throws ServletException, IOException {
        int pageNow;
        if (update_page!=-1){
            pageNow=update_page;
        }else {
            pageNow = Integer.valueOf(request.getParameter("pageNow"));
            if (pageNow<1){
                pageNow=1;
            }
        }
        //取pageSize
        int pageSize = Integer.valueOf(getServletConfig().getInitParameter("pageSize"));
        List<Deal> dealList = sfglService.queryAll(pageNow, pageSize);
        float allMoney=0; //总额
        if (!dealList.isEmpty()){
            for (int i = 0; i < dealList.size(); i++) {
                Deal deal=dealList.get(i);
                Integer companyId = deal.getCompanyId();//得到公司编号
                Company company=new Company();
                Company companyById = company.findCompanyById(companyId);//通过公司编号得到公司对象
                deal.setCompanyName(companyById.getCompany_name());//从返回的公司对象中得到名称

                //改进了，得到工人名称
                Integer workId =deal.getWorkId();
                String workName = sfglService.findNameById(workId, "work");
                deal.setWorkName(workName);
                //得到客户名称
                Integer employerId = deal.getEmployerId();
                String employerName = sfglService.findNameById(employerId, "employer");
                deal.setEmployerName(employerName);
                allMoney += dealList.get(i).getReferralFee();
            }
        }

        //总记录数
        int totalRecord = sfglService.findTotalRecord(null,null);
        //总页数
        int totalPages;
        if (totalRecord%pageSize==0){
            totalPages=totalRecord/pageSize;
        }else {
            totalPages=totalRecord/pageSize+1;
        }

        request.setAttribute("dealList",dealList);
        request.setAttribute("zonge",allMoney);//消费总额
        request.setAttribute("pageNow",pageNow);
        request.setAttribute("totalRecord",totalRecord);
        request.setAttribute("totalPages",totalPages);

        request.getRequestDispatcher("ny/cwgl/sfgl.jsp").forward(request,response);

    }
}
