package cn.eight.employservice.controller;

import cn.eight.employservice.pojo.Employer;
import cn.eight.employservice.service.EmployerService;
import cn.eight.employservice.service.impl.EmployerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ny/employersvl")
public class EmployerSvl extends HttpServlet {
    EmployerService service = new EmployerServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
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
        Float low_price = Float.parseFloat(request.getParameter("textarea11"));
        Float high_price = Float.parseFloat(request.getParameter("textarea23"));
        String remark = request.getParameter("textarea99");
        if (sex.equals("M")){
            sex = "男";
        }else {
            sex = "女";
        }
        String comrequest = "";
        for (int i = 0; i < com_request.length; i++) {
            comrequest += com_request[i]+",";
        }
        comrequest=comrequest.substring(0,comrequest.length()-1);
        Employer employer = new Employer(null,name,sex,Integer.valueOf(age),nation,address,edu,idcard,workunit,occ,contractid,contracttime,mphone,phone,nowaddress,resaddress,servaddress,fam_address,fam_people,comrequest,fam_content,fam_area,fam_diet,fam_other,agent,reg_time,high_price,low_price,remark);
        boolean result = service.addEmployer(employer);
        PrintWriter writer = response.getWriter();
        if (result){
            writer.print("<script>alert('添加成功')</script>");
            writer.close();
        }else {
            writer.print("<script>alert('添加失败')</script>");
            writer.close();
        }
    }
}
