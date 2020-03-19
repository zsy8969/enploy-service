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
@WebServlet(name = "SjzdServlet",urlPatterns = "/houtai/sjzdSvl",initParams = {@WebInitParam(name = "pageSize",value = "2")})
public class SjzdSvl extends HttpServlet {

    private SjzdService sjzdService = new SjzdServiceImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reqType = request.getParameter("reqType");
        if (reqType.equals("queryAll")){
            queryAllData(request,response,-1);
        }else if (reqType.equals("queryByCritria")){
            queryByCritria(request,response);
        }else if(reqType.equals("add")){
            addData(request,response);
        }else if (reqType.equals("remove")){
            removeData(request,response);
        }else if (reqType.equals("mod")){
            modData(request,response);
        }
    }

    //修改数据
    private void modData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        int pageNow = Integer.valueOf(request.getParameter("pageNow"));
        String name = request.getParameter("vo.name");
        String remarks = request.getParameter("vo.description");
        int id = Integer.valueOf(request.getParameter("id"));
        Sjzd data=new Sjzd(id,name,remarks,null);

        boolean result = sjzdService.modData(data);
        if (result){
            try {
                queryAllData(request,response,pageNow);
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

    //删除数据
    private void removeData(HttpServletRequest request, HttpServletResponse response) {
        String[] ids = request.getParameterValues("checkbox2");

        if (ids==null){
            try {
                response.getWriter().print("<script>window.alert('请选择记录！');window.history.back()</script>");
                response.getWriter().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            int pageNow=Integer.valueOf(request.getParameter("pageNow"));
            boolean result = sjzdService.removeData(ids);
            if (result){
                try {
                    queryAllData(request,response,pageNow);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    response.getWriter().print("<script>window.alert('删除失败！');window.history.back()</script>");
                    response.getWriter().flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    //新增数据
    private void addData(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name");
        int sortInt = Integer.valueOf(request.getParameter("selectAdd"));
        String remarks = request.getParameter("remarks");
        int pageSize = Integer.valueOf(getServletConfig().getInitParameter("pageSize"));
        //得到总记录数
        int totalRecord = sjzdService.findTotalRecord(null);
        //总页数
        int totalPages=0;
        if (totalRecord%pageSize==0){
            totalPages=totalRecord/pageSize;
        }else {
            totalPages=totalRecord/pageSize+1;
        }

        if (name.isEmpty()){
            try {
                response.getWriter().print("<script>window.alert('名称不能为空！');window.history.back()</script>");
                response.getWriter().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            Sjzd data=new Sjzd(null,name,remarks,sortInt);

            boolean result = sjzdService.addData(data);
            if (result){
                try {
                    queryAllData(request,response,totalPages);//跳到最后一页
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    response.getWriter().print("<script>window.alert('添加失败！');window.history.back()</script>");
                    response.getWriter().flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //按条件查询
    private void queryByCritria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int sortInt = Integer.valueOf(request.getParameter("selectSort"));
        int pageSize = Integer.valueOf(getServletConfig().getInitParameter("pageSize"));
        int pageNow = Integer.valueOf(request.getParameter("pageNow"));
        if (pageNow<1){
            pageNow=1;
        }

        List<Sjzd> datasList = sjzdService.queryDataByCritria(sortInt,pageNow,pageSize);
        if (datasList.isEmpty()){
            try {
                response.getWriter().print("<script>window.alert('无该记录！');window.history.back()</script>");
                response.getWriter().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            //根据数字判断类型
            for (int i = 0; i < datasList.size(); i++) {
                Sjzd datas = datasList.get(i);
                datas.sortInttoStr(datas);
            }

            //总记录数
            int totalRecordByCritria = sjzdService.findTotalRecord(sortInt);
            //总页数
            int totalPages;
            if (totalRecordByCritria%pageSize==0){
                totalPages=totalRecordByCritria/pageSize;
            }else {
                totalPages=totalRecordByCritria/pageSize+1;
            }

            request.setAttribute("datasList",datasList);
            request.setAttribute("pageNow",pageNow);
            request.setAttribute("totalRecord",totalRecordByCritria);
            request.setAttribute("totalPages",totalPages);
            request.setAttribute("sortInt",sortInt);

            request.getRequestDispatcher("ny/xtgl/basedate_cx.jsp").forward(request,response);
        }

    }

    //查询所有记录
    private void queryAllData(HttpServletRequest request, HttpServletResponse response,int update_page) throws ServletException, IOException {
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


        //根据数字判断类型
        for (int i = 0; i < allDataList.size(); i++) {
            Sjzd datas = allDataList.get(i);
            datas.sortInttoStr(datas);
        }
        //总记录数
        int totalRecord = sjzdService.findTotalRecord(null);
        //总页数
        int totalPages;
        if (totalRecord%pageSize==0){
            totalPages=totalRecord/pageSize;
        }else {
            totalPages=totalRecord/pageSize+1;
        }

        request.setAttribute("allDataList",allDataList);
        request.setAttribute("pageNow",pageNow);
        request.setAttribute("totalRecord",totalRecord);
        request.setAttribute("totalPages",totalPages);

        request.getRequestDispatcher("ny/xtgl/basedate_list.jsp").forward(request,response);
    }
}
