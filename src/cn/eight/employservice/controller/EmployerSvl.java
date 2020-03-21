package cn.eight.employservice.controller;

import cn.eight.employservice.pojo.*;
import cn.eight.employservice.service.EmployerService;
import cn.eight.employservice.service.impl.EmployerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/ny/employersvl")
public class EmployerSvl extends HttpServlet {
    EmployerService service = new EmployerServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String reqType = request.getParameter("reqType");
        if (reqType.equals("addEmployer")){
            addEmployer(request,response);//增加雇主信息
        }else if (reqType.equals("queryEmployer")){
            queryEmployer(request,response);//查询雇主信息
        }else if (reqType.equals("addusework")){
            addUseWork(request,response);//增加用工管理
        }else if (reqType.equals("useWork")){
            useWork(request,response);
        }else if (reqType.equals("changeByname")){
            changeByName(request,response);
        }else if (reqType.equals("queryDeal")){
            queryDeal(request,response);
        }else if (reqType.equals("queryDealAll")){
            queryDealAll(request,response);
        }else if (reqType.equals("updateDeal")){
            updateDeal(request,response);
        }else if (reqType.equals("updateUseWork")){
            updateUseWork(request,response);
        }else if (reqType.equals("queryEmpAll")){
            queryEmpAll(request,response);
        }else if (reqType.equals("updateEmpAll")){
            updateEmpAll(request,response);
        }else if (reqType.equals("updateEmpAllDb")){
            updateEmpAllDb(request,response);
        }else if (reqType.equals("queryWorker")){
            queryWorker(request,response);
        }else if (reqType.equals("recharge")){
            recharge(request,response);
        }else if (reqType.equals("rechargerecord")){
            rechargeRecord(request,response);
        }else if (reqType.equals("queryCash")){
            queryCash(request,response);
        }else if (reqType.equals("queryCashByParam")){
            queryCashByParam(request,response);
        }else if (reqType.equals("queryRechargeByParam")){
            queryRechargeByParam(request,response);
        }

    }


    //带参查询充值管理
    private void queryRechargeByParam(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String company_name = request.getParameter("searchName");
        String company_account = request.getParameter("searchName3");
        Recharge recharge = new Recharge(company_name,company_account);
        List<Recharge> recharges = service.queryRechargeByParam(recharge);
        request.setAttribute("recharges",recharges);
        request.getRequestDispatcher("/ny/xtgl/czgl.jsp").forward(request,response);
    }

    //带参数查询消费
    private void queryCashByParam(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String company_name = request.getParameter("searchName");
        String company_account = request.getParameter("searchName3");
        String date = request.getParameter("searchName2");
        String date1 = request.getParameter("searchName4");
        QueryCash queryCash = new QueryCash(company_name,company_account,date,date1);
        List<QueryCash> queryCashes = service.queryCashByParam(queryCash);
        request.setAttribute("queryCashes",queryCashes);
        request.getRequestDispatcher("/ny/xtgl/xfcx.jsp").forward(request,response);
    }


    //查询消费记录
    private void queryCash(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<QueryCash> queryCashes = service.queryCash();
        request.setAttribute("queryCashes",queryCashes);
        request.getRequestDispatcher("/ny/xtgl/xfcx.jsp").forward(request,response);
    }


    //添加充值记录
    private void rechargeRecord(HttpServletRequest request, HttpServletResponse response) {
        String company_id = request.getParameter("company_id");
        String money = request.getParameter("textarea4");
        String record = request.getParameter("textarea35");
        Date date = new Date();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format = sdf.format(date);
        RechargeRocard rocard = new RechargeRocard(record,money,"1",format,company_id);
        boolean result = service.addRechargeRecord(rocard);
        response.setHeader("contentType", "text/html; charset=utf-8");
    }


    //充值管理
    private void recharge(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Recharge> recharges = service.queryRecharge();
        request.setAttribute("recharges",recharges);
        request.getRequestDispatcher("/ny/xtgl/czgl.jsp").forward(request,response);
    }

    //查询工人信息
    private void queryWorker(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name").trim();
        String sex = request.getParameter("sex");
        String age1 = request.getParameter("select1").trim();
        String age2 = request.getParameter("select2").trim();
        String worktime = request.getParameter("worktime").trim();
        String edu = request.getParameter("edu");
        String[] hobbit = request.getParameterValues("hobbit");
        String[] luange = request.getParameterValues("luange");
        String luange1 = request.getParameter("luange1").trim();
        String statu = request.getParameter("statu");
        String otherstatu = request.getParameter("otherstatu").trim();
        String merry = request.getParameter("merry");
        String othermerry = request.getParameter("othermerry").trim();
        String[] pic = request.getParameterValues("pic");
        String[] skill = request.getParameterValues("skill");
        String otherskill = request.getParameter("otherskill").trim();
        WorkerQuery wq = new WorkerQuery(name,sex,age1,age2,worktime,edu,hobbit,luange,luange1,statu,otherstatu,merry,othermerry,pic,skill,otherskill);
        List<Worker> workers = service.queryWorker(wq);
        if (workers.size()==0){
            request.getRequestDispatcher("/ny/ywgl/grxx_cx.jsp").forward(request,response);
        }else {
            request.setAttribute("workers",workers);
            request.getRequestDispatcher("/ny/rlzy/grxx.jsp").forward(request,response);
        }

    }

    //提交修改的雇主信息到数据库
    private void updateEmpAllDb(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String emp_id = request.getParameter("emp_id");
        String name = request.getParameter("name");
        String sex = request.getParameter("radio");
        String age = request.getParameter("age");
        String nation = request.getParameter("nation");
        String address = request.getParameter("address");
        String edu = request.getParameter("edu");
        String workunit = request.getParameter("workunit");
        String idcard = request.getParameter("idcard");
        String occ = request.getParameter("occ");
        String contractid = request.getParameter("contractid");
        String contracttime = request.getParameter("contracttime");
        String phone = request.getParameter("phone");
        String mphone = request.getParameter("mphone");
        String resaddress = request.getParameter("resaddress");
        String servaddress = request.getParameter("servaddress");
        String fam_address = request.getParameter("fam_address");
        String fam_people = request.getParameter("fam_people");
        String com_request = request.getParameter("com_request");
        String fam_area = request.getParameter("fam_area");
        String fam_diet = request.getParameter("fam_diet");
        String fam_other = request.getParameter("fam_other");
        String remark = request.getParameter("remark");
        String agent = request.getParameter("agent");
        String reg_time = request.getParameter("reg_time");
        Employer employer = new Employer(name,sex,age,nation,address,edu,idcard,workunit,occ,contractid,contracttime,mphone,phone,resaddress,servaddress,fam_address,fam_people,com_request,fam_area,fam_diet,fam_other,agent,reg_time,remark,emp_id);
        boolean result = service.updateEmp(employer);
        PrintWriter writer = response.getWriter();
        if (result){
            writer.print("<script>alert('success')</script>");
            writer.close();
        }else {
            writer.print("<script>alert('fail')</script>");
            writer.close();
        }

    }


    //雇主id查询雇主信息
    private void updateEmpAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String emp_id = request.getParameter("emp_id");
        List<Employer> employers = service.queryEmpAll(emp_id);
        request.setAttribute("allemp",employers);
        request.getRequestDispatcher("/ny/ywgl/gzxx_xg.jsp").forward(request,response);
    }


    //查看雇主详细信息
    private void queryEmpAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String emp_id = request.getParameter("emp_id");
        List<Employer> employers = service.queryEmpAll(emp_id);
        request.setAttribute("allemp",employers);
        request.getRequestDispatcher("/ny/ywgl/gzxx_ck.jsp").forward(request,response);
    }

    //修改用工合同
    private void updateUseWork(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String dealid = request.getParameter("dealid");
        String emp_id = request.getParameter("emp_id");
        String work_id = request.getParameter("work_id");
        String ahentid = request.getParameter("textarea212");
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String regtime = df.format(date);
        String dealtime = request.getParameter("textarea271");
        String statue = request.getParameter("select11");
        String price = request.getParameter("textarea221");
        String other = request.getParameter("textarea90");
        String[] com_request = request.getParameterValues("checkbox");
        String comrequest = "";
        if (com_request!=null){
            for (int i = 0; i < com_request.length; i++) {
                comrequest += com_request[i]+",";
            }
            comrequest=comrequest.substring(0,comrequest.length()-1);
        }
        String introprice = request.getParameter("textarea294");
        String deal_time = null;
        if (statue.equals("已成交")||statue.equals("在别处成交")){
            deal_time = dealtime;
        }
        Deal deal = new Deal(Integer.valueOf(dealid),Integer.valueOf(ahentid),Integer.valueOf(price),Integer.valueOf(introprice),null,Integer.valueOf(work_id),Integer.valueOf(emp_id),regtime,dealtime,statue,comrequest,deal_time,other);
        boolean result = service.updateDeal(deal);
        PrintWriter writer = response.getWriter();
        if (result){
            writer.print("<script>alert('success')</script>");
            writer.close();
        }else {
            writer.print("<script>alert('fail')</script>");
            writer.close();
        }
    }

    //修改用工合同
    private void updateDeal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dealid = request.getParameter("dealid");
        List<Object> list = service.updateDeal(dealid);
        request.setAttribute("dealList",list);
        request.getRequestDispatcher("/ny/ywgl/ddgl_xg.jsp").forward(request,response);
    }


    //查询订单详细信息
    private void queryDealAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dealid = request.getParameter("dealid");
        List<Object> list = service.queryDealAll(dealid);
        request.setAttribute("List",list);
        request.getRequestDispatcher("/ny/ywgl/ddgl_ck.jsp").forward(request,response);
    }

    private void queryDeal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empname = request.getParameter("searchName");
        String regtime = request.getParameter("searchName2");
        String regtime1 = request.getParameter("searchName3");
        String workname = request.getParameter("searchName4");
        String statu = request.getParameter("select");
        if (statu.equals("请选择")){
            statu = "";
        }
        QueryDeal qd = new QueryDeal(empname,regtime,regtime1,workname,statu);
        List<QueryDeal> queryDealList = service.queryDeal(qd);
        request.setAttribute("queryDealList",queryDealList);
        request.getRequestDispatcher("/ny/ywgl/ddgl.jsp").forward(request,response);
    }

    private void changeByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        List<Employer> employers = service.queryByName(name);
        request.setAttribute("employers",employers);
        request.getRequestDispatcher("/ny/ywgl/ddgl_xz.jsp").forward(request,response);
    }

    private void addUseWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employer> employers = service.queryEmployerOther();
        request.setAttribute("employers",employers);
        request.getRequestDispatcher("/ny/ywgl/ddgl_xz.jsp").forward(request,response);
    }

    private void useWork(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String emp_id = request.getParameter("emp_id");
        String ahentid = request.getParameter("textarea212");
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String regtime = df.format(date);
        String dealtime = request.getParameter("textarea271");
        String statue = request.getParameter("select11");
        String price = request.getParameter("textarea221");
        String other = request.getParameter("textarea90");
        String[] com_request = request.getParameterValues("checkbox");
        String comrequest = "";
        if (com_request!=null){
            for (int i = 0; i < com_request.length; i++) {
                comrequest += com_request[i]+",";
            }
            comrequest=comrequest.substring(0,comrequest.length()-1);
        }
        String introprice = request.getParameter("textarea294");
        String deal_time = null;
        if (statue.equals("已成交")||statue.equals("在别处成交")){
            deal_time = dealtime;
        }
        Deal deal = new Deal(null,Integer.valueOf(ahentid),Integer.valueOf(price),Integer.valueOf(introprice),null,null,Integer.valueOf(emp_id),regtime,dealtime,statue,comrequest,deal_time,other);
        boolean result = service.addDeal(deal);
        PrintWriter writer = response.getWriter();
        if (result){
            writer.print("<script>alert('success')</script>");
            writer.close();
        }else {
            writer.print("<script>alert('fail')</script>");
            writer.close();
        }
    }

    private void queryEmployer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("searchName").trim();
        String sex = request.getParameter("radio");
        if (sex!=null&&sex!=""&&sex.equals("M")){
            sex = "男";
        }else if (sex!=null&&sex!=""&&sex.equals("W")){
            sex = "女";
        }else if (sex == null){
            sex = "";
        }
        String emrequest = request.getParameter("select2");
        if (emrequest.trim().equals("请选择")){
            emrequest = "";
        }
        String phone = request.getParameter("searchPhone");
        Employer employer = new Employer(name,sex,phone,emrequest);
        List<Employer> employers = service.queryEmployer(employer);
        request.setAttribute("employers",employers);
        request.getRequestDispatcher("ywgl\\gzxx.jsp").forward(request,response);
    }

    private void addEmployer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("textarea40");
        String sex = request.getParameter("radio");
        String age = request.getParameter("textarea");
        String nation = request.getParameter("textarea2");
        String address = request.getParameter("textarea5");
        String edu = request.getParameter("textarea4");
        String idcard = request.getParameter("textarea3");
        String workunit = request.getParameter("textarea6");
        String occ = request.getParameter("textarea7");
        String contractid = request.getParameter("textarea8");
        String contracttime = request.getParameter("textarea9");
        String mphone = request.getParameter("textarea10");
        String phone = request.getParameter("textarea10");
        String nowaddress = request.getParameter("textarea111");
        String resaddress = request.getParameter("textarea12");
        String servaddress = request.getParameter("textarea13");
        String fam_address = request.getParameter("textarea14");
        String fam_people = request.getParameter("textarea15");
        String[] com_request = request.getParameterValues("checkbox");
        String fam_content = request.getParameter("textarea16");
        String fam_area = request.getParameter("textarea17");
        String fam_diet = request.getParameter("textarea18");
        String fam_other = request.getParameter("textarea19");
        String agent = request.getParameter("textarea21");
        String reg_time = request.getParameter("textarea22");
        String lprice = request.getParameter("textarea11");
        Float low_price = 0f;
        Float high_price = 0f;
        if (lprice!=null&&lprice!=""){
            low_price = Float.parseFloat(lprice);
        }
        String hprice = request.getParameter("textarea23");
        if (lprice!=null&&lprice!=""){
            high_price = Float.parseFloat(hprice);
        }
        String remark = request.getParameter("textarea99");
        if (sex!=null&&sex!=""&&sex.equals("M")){
            sex = "男";
        }else {
            sex = "女";
        }
        String comrequest = "";
        if (com_request!=null){
            for (int i = 0; i < com_request.length; i++) {
                comrequest += com_request[i]+",";
            }
            comrequest=comrequest.substring(0,comrequest.length()-1);
        }
        Employer employer = new Employer(null,name,sex,age,nation,address,edu,idcard,workunit,occ,contractid,contracttime,mphone,phone,nowaddress,resaddress,servaddress,fam_address,fam_people,comrequest,fam_content,fam_area,fam_diet,fam_other,agent,reg_time,high_price,low_price,remark);
        boolean result = service.addEmployer(employer);
        PrintWriter writer = response.getWriter();
        if (result){
            writer.print("<script>alert('success')</script>");
            writer.close();
        }else {
            writer.print("<script>alert('fail')</script>");
            writer.close();
        }

    }
}
