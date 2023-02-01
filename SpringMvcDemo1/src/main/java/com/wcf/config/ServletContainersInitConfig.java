package com.wcf.config;

import com.wcf.config.SpringConfig;
import com.wcf.config.SpringMvcConfig;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.Filter;

//替换web.xml
public class ServletContainersInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override//乱码处理
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter=new CharacterEncodingFilter();
        filter.setEncoding("utf-8");
        return new Filter[]{filter};
    }
}

/*
以上是简化开发,下面的是原理
    @Override
    //SpringMvc配置类   servlet
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext ctx=new AnnotationConfigWebApplicationContext();
        ctx.register(SpringMvcConfig.class);
        return ctx;
        */
/*该方法加载SpringMVC的配置类SpringMvcConfig来初始化SpringMVC的容器*//*

    }

    @Override
    //SpringMvc控制器管理的路径  /表示管理所有,后期需要放行前端页面
    protected String[] getServletMappings() {
        return new String[]{"/"};//getServletMappings方法，设定SpringMVC对应的请
        // 求映射路径，即SpringMVC拦截哪些请求
    }

    @Override
    //Spring配置类   root
    protected WebApplicationContext createRootApplicationContext() {
        AnnotationConfigWebApplicationContext ctx=new AnnotationConfigWebApplicationContext();
        ctx.register(SpringConfig.class);
        return ctx;
        */
/*如果创建Servlet容器时需要加载非SpringMVC对应的bean,使用当前方法进行，
        使用方式和createServletApplicationContext相同。*//*

    }*/
