package com.wcf.web;

import com.alibaba.fastjson.JSON;
import com.wcf.pojo.Brand;
import com.wcf.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/addservlet")
public class AddServlet extends HttpServlet {
    BrandService service=new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* request.setCharacterEncoding("UTF-8");
        //接收表单
        String brandName = request.getParameter("brandName");
        String companyName = request.getParameter("companyName");
        String ordered = request.getParameter("ordered");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        *//*if(!ordered.matches("^\\d+?"))
        return;*//*
        //封装为一个Brand对象
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        System.out.println(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(Integer.parseInt(ordered));
        brand.setDescription(description);
        brand.setStatus(Integer.parseInt(status));

        //2. 调用service 完成添加
        service.add(brand);
        //System.out.println(Time);
        //3. 转发到查询所有Servlet
        System.out.println("添加add"+new Date().toString());
        request.getRequestDispatcher("/selectAllServlet").forward(request,response);*/
        BufferedReader br = request.getReader();
        String params = br.readLine();
        // 将JSON字符串转为Java对象
        Brand brand = JSON.parseObject(params, Brand.class);
        //2. 调用service 添加
        service.add(brand);
        //3. 响应成功标识
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
