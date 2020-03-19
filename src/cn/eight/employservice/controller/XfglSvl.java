package cn.eight.employservice.controller;

import cn.eight.employservice.pojo.Company;
import cn.eight.employservice.pojo.Xfgl;
import cn.eight.employservice.service.XfglService;
import cn.eight.employservice.service.serviceImp.XfglServiceImp;

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
 * @create 2020-03-19 10:24
 */
@WebServlet(urlPatterns = "/houtai/xfglSvl",name = "XfglServlet",initParams = {@WebInitParam(name = "pageSize",value = "2")})
public class XfglSvl extends HttpServlet {

    private XfglService xfglService = new XfglServiceImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reqType = request.getParameter("reqType");
        if (reqType.equals("queryAll")){
            queryAll(request,response,-1);
        }else if (reqType.equals("queryByCritria")){
            queryByTime(request,response);
        }else if (reqType.equals("print")){
            printData(request,response);
        }
    }

    private void printData(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        try {
            response.getWriter().print("<script>window.alert('打印成功！');window.history.back()</script>");
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //按时间条件查询
    private void queryByTime(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        int pageSize = Integer.valueOf(getServletConfig().getInitParameter("pageSize"));
        String startTime = request.getParameter("searchName2");
        String endTime = request.getParameter("searchName4");
        int pageNow=Integer.valueOf(request.getParameter("pageNow"));
        if (pageNow<1){
            pageNow=1;
        }

        //创建公司对象，findCompanyById通过公司编号查询公司名称
        Company company=new Company();
        //总额
        float allMoney=0;

        List<Xfgl> xfglsByTime = xfglService.queryByTime(startTime,endTime,pageNow,pageSize);

        if (xfglsByTime.size()!=0){
            for (int i = 0; i < xfglsByTime.size(); i++) {
                Integer company_id = xfglsByTime.get(i).getCompany_id();//得到公司编号
                Company companyById = company.findCompanyById(company_id);//得到公司对象
                //将公司对象中的名称放进xfgls中的Xfgl对象中的company_name
                xfglsByTime.get(i).setCompany_name(companyById.getCompany_name());
                //得到消费类型typeInt
                Integer consume_typeInt = xfglsByTime.get(i).getConsume_typeInt();
                //调用pojo中Xfgl中的消费类型转换方法
                xfglsByTime.get(i).typeInttoStr(xfglsByTime.get(i));
                allMoney += xfglsByTime.get(i).getConsume_money();
            }
                int totalRecord = xfglService.totalRecord(startTime,endTime);
                int totalPages;
                if (totalRecord%pageSize==0){
                    totalPages=totalRecord/pageSize;
                }else {
                    totalPages=totalRecord/pageSize+1;
                }

                request.setAttribute("xfglList",xfglsByTime);//查询的数据
                request.setAttribute("zonge",allMoney);//消费总额
                request.setAttribute("pageNow",pageNow);//当前页数
                request.setAttribute("totalRecord",totalRecord);//总记录数
                request.setAttribute("totalPages",totalPages);//总页数
                //查询条件
                request.setAttribute("startTime",startTime);
                request.setAttribute("endTime",endTime);
                request.getRequestDispatcher("ny/cwgl/xfgl_cx.jsp").forward(request,response);

        }else {
            try {
                response.getWriter().print("<script>window.alert('无记录！');window.history.back()</script>");
                response.getWriter().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    //查询所有记录并分页展示
    private void queryAll(HttpServletRequest request, HttpServletResponse response,Integer update_page) throws ServletException, IOException {

        int pageSize = Integer.valueOf(getServletConfig().getInitParameter("pageSize"));
        int pageNow;
        if (update_page!=-1){
            pageNow=update_page;
        }else {
            pageNow=Integer.valueOf(request.getParameter("pageNow"));
            if (pageNow<1){
                pageNow=1;
            }
        }
       //创建公司对象，findCompanyById通过公司编号查询公司名称
        Company company=new Company();
        //总额
        float allMoney=0;

        //查询返回的List集合
        List<Xfgl> xfgls = xfglService.queryAll(pageNow, pageSize);

        for (int i = 0; i < xfgls.size(); i++) {
            Integer company_id = xfgls.get(i).getCompany_id();//得到公司编号
            Company companyById = company.findCompanyById(company_id);//得到公司对象
            //将公司对象中的名称放进xfgls中的Xfgl对象中的company_name
            xfgls.get(i).setCompany_name(companyById.getCompany_name());
            //得到消费类型typeInt
            Integer consume_typeInt = xfgls.get(i).getConsume_typeInt();
            //调用pojo中Xfgl中的消费类型转换方法
             xfgls.get(i).typeInttoStr(xfgls.get(i));
             allMoney+=xfgls.get(i).getConsume_money();
        }

        int totalRecord = xfglService.totalRecord(null,null);
        int totalPages;
        if (totalRecord%pageSize==0){
            totalPages=totalRecord/pageSize;
        }else {
            totalPages=totalRecord/pageSize+1;
        }


        request.setAttribute("xfglList",xfgls);//查询的数据
        request.setAttribute("zonge",allMoney);//消费总额
        request.setAttribute("pageNow",pageNow);//当前页数
        request.setAttribute("totalRecord",totalRecord);//总记录数
        request.setAttribute("totalPages",totalPages);//总页数

        request.getRequestDispatcher("ny/cwgl/bbcx.jsp").forward(request,response);

    }

}
