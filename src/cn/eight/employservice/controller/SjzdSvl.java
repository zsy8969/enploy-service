package cn.eight.employservice.controller;

import cn.eight.employservice.pojo.Sjzd;
import cn.eight.employservice.service.SjzdService;
import cn.eight.employservice.service.serviceImp.SjzdServiceImp;

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
 * @create 2020-03-18 10:26
 */
@WebServlet(name = "SjzdServlet",urlPatterns = "/houtai/sjzdSvl",initParams = {@WebInitParam(name = "pageSize",value = "10")})
public class SjzdSvl extends HttpServlet {

    private SjzdService sjzdService = new SjzdServiceImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reqType = request.getParameter("reqType");
        if (reqType.equals("queryAll")){
            queryAllData(request,response,-1);
        }
    }

    private void queryAllData(HttpServletRequest request, HttpServletResponse response,int update_page) {
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

        List<Sjzd> allDataList = sjzdService.queryAllData(pageNow, pageSize);
        System.out.println(allDataList.get(0).getSort());
    }
}
