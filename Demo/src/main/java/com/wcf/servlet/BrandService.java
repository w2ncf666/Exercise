package com.wcf.servlet;

/*import com.alibaba.fastjson.JSON;*/
import com.alibaba.fastjson.JSON;
import com.wcf.pojo.Brand;
import com.wcf.pojo.Page;
import com.wcf.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/*@WebServlet("/brand/*")*/
public class BrandService extends BaseServlet {


    /*
    *
    * /这块重点!!BrandServiceImpl是BrandService的实现类,将来如果BrandServiceImpl里面的代码改变
    * 就不必更改Servlet的代码,即service可以复用*/
    private com.wcf.service.BrandService service = new BrandServiceImpl();


    /*public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Brand> brands = service.selectAll();
        String jsonString = JSON.toJSONString(brands);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }*/

    /*public void selectAllLimit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _currentPage = request.getParameter("currentPage");
        String _size = request.getParameter("size");
        int current = Integer.parseInt(_currentPage);//2
        int size = Integer.parseInt(_size);//10
        System.out.println(current);
        System.out.println(size);



        List<Brand> brands = service.selectAllLimit((current-1)*size,size);//10-20
        String jsonString = JSON.toJSONString(brands);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }*/


    /*所有的查询列表处理*/
    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*处理request获取的页码数据变成int*/
        String _currentPage = request.getParameter("currentPage");
        String _size = request.getParameter("size");
        int current = Integer.parseInt(_currentPage);//2
        int size = Integer.parseInt(_size);//10

        /*处理post过来的数据*/
        BufferedReader reader = request.getReader();
        String readLine = reader.readLine();
        Brand brand = JSON.parseObject(readLine, Brand.class);

        /*String companyName = brand.getCompanyName();
        if (companyName != null && companyName.length() > 0) {
            companyName = "%" + companyName + "%";
            brand.setCompanyName(companyName);
        }
        String brandName = brand.getBrandName();
        if (brandName != null && brandName.length() > 0) {
            brandName = "%" + brandName + "%";
            brand.setBrandName(brandName);
        }*/
        /*调用service*/
       /* List<Brand> brands = service.selectByPageAndCondition((current - 1) * size, size, brand);
        Integer totalCount = service.selectTotalCount(brand);

        *//*封装成page*//*
        Page<Brand> page = new Page();
        page.setList(brands);
        page.setTotalCount(totalCount);

        *//*response到前端*//*
        String jsonString = JSON.toJSONString(page);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);*/

    }

    /*单个添加*/
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String readLine = reader.readLine();
        Brand brand = JSON.parseObject(readLine, Brand.class);
        service.add(brand);
        response.getWriter().write("success");
        //System.out.println(readLine);
        /*if(brand.getStatusStr().equals("禁用")){
            brand.setStatus(0);
        }
        else if(brand.getStatusStr().equals("启用")){
            brand.setStatus(1);
            System.out.println("elseif");
            System.out.println(brand.getStatus());
        }
        System.out.println(brand.getStatus());*/
        //System.out.println(brand);
    }

    /*编辑回显*/
    public void selectById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String readLine = reader.readLine();
        Brand brand = JSON.parseObject(readLine, Brand.class);
        String jsonString = JSON.toJSONString(service.selectById(brand.getId()));//查询id并转化json
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    /*public void text(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String readLine = reader.readLine();
        System.out.println(readLine);
       *//* int[] ids = JSON.parseObject(readLine, int[].class);
        for (int i = 0; i < ids.length; i++) {
            System.out.println(ids[i]);
        }*//*
     *//*Brand brand = JSON.parseObject(readLine,Brand.class);
        System.out.println(brand.getId());*//*

    }*/

    /*编辑提交处理*/
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String readLine = reader.readLine();
        Brand brand = JSON.parseObject(readLine, Brand.class);
        /*if(brand.getStatusStr().equals("禁用")){
            brand.setStatus(1);
            System.out.println(brand.getStatus());
        }
        else if(brand.getStatusStr().equals("启用")){
            brand.setStatus(0);
            System.out.println(brand.getStatus());
        }*/
        //System.out.println(brand);
        service.update(brand);
        response.getWriter().write("success");
    }


    /*单个删除*/
    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String readLine = reader.readLine();
        Brand brand = JSON.parseObject(readLine, Brand.class);

        //System.out.println(brand);
        service.deleteById(brand);
        response.getWriter().write("success");
    }


    /*批量删除*/
    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String readLine = reader.readLine();
        int[] ids = JSON.parseObject(readLine, int[].class);
        //System.out.println(brand);
        service.deleteByIds(ids);
        response.getWriter().write("success");
    }


    /*public void selectTotalCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int totalCount = service.selectTotalCount();
        System.out.println(totalCount);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(totalCount);
    }*/


    /*public void selectByConditions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String readLine = reader.readLine();
        Brand brand = JSON.parseObject(readLine, Brand.class);

        //System.out.println(brand);
        String companyName = brand.getCompanyName();
        if (companyName != null && companyName.length() > 0) {
            companyName = "%" + companyName + "%";
            brand.setCompanyName(companyName);
        }
        String brandName = brand.getBrandName();
        if (brandName != null && brandName.length() > 0) {
            brandName = "%" + brandName + "%";
            brand.setBrandName(brandName);
        }

        System.out.println(brand);
        List<Brand> brands = service.selectByConditions(brand);
        String jsonString = JSON.toJSONString(brands);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }*/


}
