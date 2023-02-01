package com.wcf.web;

import com.wcf.pojo.Brand;
import com.wcf.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    BrandService service=new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Brand> brands= service.selectAll();
        request.setAttribute("brands",brands);
        System.out.println("查询"+new Date().toString());
        request.getRequestDispatcher("/brand.jsp").forward(request,response);
        //System.out.println("get...");
        //1. 接收请求参数
        /*String username = request.getParameter("username");
        System.out.println(username);
        //2. 响应数据
        response.getWriter().write("hello Axios~");*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    //System.out.println("get...");
    //        //1. 接收请求参数
    //        String username = request.getParameter("username");
    //        System.out.println(username);
    //        //2. 响应数据
    //        response.getWriter().write("hello Axios~");
}
