package cn.eight.employservice.controller;

import cn.eight.employservice.pojo.Company;
import cn.eight.employservice.service.GsglService;
import cn.eight.employservice.service.serviceImp.GsglServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author 瞿琮
 * @create 2020-03-16 17:01
 */
@WebServlet(name = "GsglServlet",urlPatterns = "/houtai/gsglSvl",initParams = {@WebInitParam(name = "pageSize",value = "10")})
public class GsglSvl extends HttpServlet {

    private GsglService gsglService= new GsglServiceImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reqType = request.getParameter("reqType");
        if (reqType.equals("add")){
            addCompany(request,response);
        }else if (reqType.equals("allCompany")){
            queryAllCompany(request,response,-1);
        }else if (reqType.equals("queryCompany")){
            queryCompanyByCritria(request,response);
        }else if (reqType.equals("removeCompany")){
            removeCompany(request,response);
        }else if (reqType.equals("mod")){
            modCompany(request,response);
        }
    }

    //修改记录
    private void modCompany(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        int company_id =Integer.valueOf(request.getParameter("id"));
        String company_account = request.getParameter("account");
        String company_Name = request.getParameter("name");
        String company_intro = request.getParameter("intro");
        int pageNow = Integer.valueOf(request.getParameter("pageNow"));

        Company company=new Company(company_id,company_account,company_Name,company_intro);
        boolean result = gsglService.modCompany(company);
        if (result){
            try {
                queryAllCompany(request,response,pageNow);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            response.getWriter().print("<script>window.alert('修改失败！');window.history.back()</script>");
            response.getWriter().flush();
        }


    }

    //删除记录
    private void removeCompany(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] checkboxes = request.getParameterValues("checkbox2");
        System.out.println(checkboxes.length);
        if (checkboxes==null){
            response.getWriter().print("<script>window.alert('请选择记录！');window.history.back()</script>");
            response.getWriter().flush();
        }else {
            int pageNow=Integer.valueOf(request.getParameter("pageNow"));
            boolean result = gsglService.removeCompany(checkboxes);
            if (result){
                try {
                    queryAllCompany(request,response,pageNow);
                } catch (ServletException e) {
                    e.printStackTrace();
                }
            }else {
                response.getWriter().print("<script>window.alert('删除失败！');window.history.back()</script>");
                response.getWriter().flush();
            }
        }


    }

    //按条件查询公司
    private void queryCompanyByCritria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String queryAccount = request.getParameter("queryAccount");
        String queryName = request.getParameter("queryName");

        List<Company> companyList = gsglService.queryCompanyByCritria(queryAccount, queryName);
        if (companyList.isEmpty()){
            response.getWriter().print("<script>window.alert('无"+queryName+"该公司记录！');window.history.back()</script>");
            response.getWriter().flush();
        }else {
            request.setAttribute("companies",companyList);
            request.getRequestDispatcher("ny/xtgl/gsgl.jsp").forward(request,response);
        }

    }

    //查询所有公司
    private void queryAllCompany(HttpServletRequest request, HttpServletResponse response,int update_page) throws ServletException, IOException {
        int pageNow;
        if (update_page==-1){
            pageNow = Integer.valueOf(request.getParameter("pageNow"));
            if (pageNow<1){
                pageNow=1;
            }
        }else {
            pageNow=update_page;
        }

        //取出在本servlet的注释中写入了初始参数
        int pageSize = Integer.valueOf(getServletConfig().getInitParameter("pageSize"));

        List<Company> companyList = gsglService.queryAllCompany(pageNow, pageSize);
        //得到总记录数
        int totalRecord = gsglService.findTotalRecord();
        //总页数
        int totalPages=0;
        if (totalRecord%pageSize==0){
            totalPages=totalRecord/pageSize;
        }else {
            totalPages=totalRecord/pageSize+1;
        }
        if (pageNow>totalPages){//当下一页超过最后一页是不能再继续往后
            pageNow=totalPages;
        }
        request.setAttribute("companies",companyList);
        request.setAttribute("totalRecord",totalRecord);
        request.setAttribute("totalPages",totalPages);
        request.setAttribute("pageNow",pageNow);
        request.getRequestDispatcher("ny/xtgl/gsgl.jsp").forward(request,response);
    }

    //新增公司
    private void addCompany(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
        String company_account = request.getParameter("account");
        String company_Name = request.getParameter("name");
        String explain = request.getParameter("intro");

        Company company=new Company(null,company_account,company_Name,explain);

        boolean result = gsglService.addCompany(company);
        if (result){//成功后返回到最后一页
            //取出在本servlet的注释中写入了初始参数
            int pageSize = Integer.valueOf(getServletConfig().getInitParameter("pageSize"));
            //得到总记录数
            int totalRecord = gsglService.findTotalRecord();
            //总页数
            int totalPages=0;
            if (totalRecord%pageSize==0){
                totalPages=totalRecord/pageSize;
            }else {
                totalPages=totalRecord/pageSize+1;
            }
            try {
                queryAllCompany(request,response,totalPages);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try {
                response.getWriter().print("<script>window.alert('新增失败！');window.history.back()</script>");
                response.getWriter().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
