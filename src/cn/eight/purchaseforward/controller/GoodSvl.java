package cn.eight.purchaseforward.controller;

import cn.eight.purchaseforward.pojo.CarBean;
import cn.eight.purchaseforward.pojo.Good;
import cn.eight.purchaseforward.service.GoodService;
import cn.eight.purchaseforward.service.impl.GoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/qiantai/goodsvl")
public class GoodSvl extends HttpServlet {
    private GoodService service = new GoodServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reqType = request.getParameter("reqType");
        if (reqType.equals("main")) {
            openMain(request, response);
        } else if (reqType.equals("downImg")) {
            downImg(request, response);
        }else if (reqType.equals("addCar")){
            addCar(request,response);
        }else if (reqType.equals("delCar")){
            delCar(request,response);
        }else if (reqType.equals("clearCar")){
            clearCar(request,response);
        }else if (reqType.equals("modCar")){
            modCar(request,response);
        }else if (reqType.equals("flow")){
            openCar(request,response);
        }else if (reqType.equals("calculator")){
            calculator(request,response);
        }
    }

    //结算
    private void calculator(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        CarBean carBean = (CarBean)session.getAttribute("Car");
        Integer blance = carBean.getBlance();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print("<script>alert('支付成功，金额是"+blance+"')</script>");
        writer.print("<script>window.location.href = 'goodsvl?reqType=main'</script>");
        writer.flush();
        writer.close();
    }

    private void openCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        CarBean carBean = (CarBean)session.getAttribute("Car");
        List<Good> goodList = service.findCars(carBean);
        request.setAttribute("car",goodList);
        request.getRequestDispatcher("flow.jsp").forward(request,response);
    }

    private void modCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //取数量与id
        String[] goodids = request.getParameterValues("goodids");
        String[] amounts = request.getParameterValues("amounts");
        Integer[] goodids_int = new Integer[goodids.length];
        Integer[] amounts_int = new Integer[amounts.length];
        for (int i = 0; i < goodids.length; i++) {
            goodids_int[i] = Integer.valueOf(goodids[i]);
            amounts_int[i] = Integer.valueOf(amounts[i]);
        }
        HttpSession session = request.getSession();
        CarBean carBean = (CarBean)session.getAttribute("Car");
        carBean.modGood(goodids_int,amounts_int);
        genericCarData(request,response,carBean,session);
    }

    private void clearCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        CarBean carBean = (CarBean)session.getAttribute("Car");
        carBean.clearCar();
        genericCarData(request,response,carBean,session);
    }

    private void delCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("goodid"));
        HttpSession session = request.getSession();
        CarBean carBean = (CarBean)session.getAttribute("Car");
        carBean.removeGood(id);
        genericCarData(request,response,carBean,session);
    }

    private void addCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("goodid"));
        HttpSession session = request.getSession();
        CarBean carBean = (CarBean)session.getAttribute("Car");
        if (carBean == null){
            carBean = new CarBean();
        }
        carBean.addGood(id);
        genericCarData(request,response,carBean,session);

    }

    //把购物车对象中的id取出其其它属性
    private void genericCarData(HttpServletRequest request, HttpServletResponse response,CarBean carBean,HttpSession session) throws ServletException, IOException {
        session.setAttribute("Car",carBean);
        List<Good> goodList = service.findCars(carBean);
        request.setAttribute("car",goodList);
        request.getRequestDispatcher("flow.jsp").forward(request,response);
    }

    //向客户端发送图片
    private void downImg(HttpServletRequest request, HttpServletResponse response) {
        String filename = request.getParameter("filename");
        String path = request.getServletContext().getRealPath("/WEB-INF/upload/" + filename);
        FileInputStream fis = null;
        ServletOutputStream os = null;
        try {
            int len = 0;
            byte[] buff = new byte[1024];
            fis = new FileInputStream(path);
            os = response.getOutputStream();
            while ((len = fis.read(buff)) != -1) {
                os.write(buff, 0, len);
            }
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void openMain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goodType = request.getParameter("goodType");
        //取出所有的商品类别
        List<String> goodTypes = service.findAllGoodType();
        List<Good> goodsList = null;
        if (goodTypes.size() > 0) {
            if (goodType == null||goodType.isEmpty()){
                //取第一个
                goodType = goodTypes.get(0);
            }
            //取出该类别的所有商品
            goodsList = service.findGoodsByType(goodType);
        }
        HttpSession session = request.getSession();
        CarBean carBean = (CarBean) session.getAttribute("Car");
        int amount = 0;
        int blance = 0;
        if (carBean!=null){
            amount = carBean.getAmounts();
            blance = carBean.getBlance();
        }
        request.setAttribute("amount",amount);
        request.setAttribute("blance",blance);
        request.setAttribute("goodTypes", goodTypes);
        request.setAttribute("goodList", goodsList);
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }
}
