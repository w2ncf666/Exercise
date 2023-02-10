package com.wcf.pojo;

import com.alibaba.fastjson.JSON;
import com.wcf.Util.BaseContextUtil;
import com.wcf.reastic.Employee;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Slf4j
public class Interceptor implements HandlerInterceptor {
    @Override//有bug
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        /* public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Long id = (Long) request.getSession().getAttribute("employee");
        if(id==null)//res.data.code === 0 && res.data.msg === 'NOTLOGIN'
       {
           R<Employee> error = R.error("NOTLOGIN");
           String jsonString = JSON.toJSONString(error);
           response.getWriter().write(jsonString);
           return false;
       }
        BaseContextUtil.setCurrentId(id);
       return true;
    }*/
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        log.info(requestURL+"在这里查看uri");
        log.info(requestURI+"在这里查看uri");
        Long employeeId = (Long) request.getSession().getAttribute("employee");
        Long userId = (Long) request.getSession().getAttribute("user");
        log.info(employeeId+"在这里查看ID1");
        if(employeeId==null&&userId==null)//res.data.code === 0 && res.data.msg === 'NOTLOGIN'
       {//管理员
           R<Employee> error = R.error("NOTLOGIN");
           String jsonString = JSON.toJSONString(error);
           /*ServletOutputStream outputStream = response.getOutputStream();
           outputStream.write(jsonString.getBytes());
           outputStream.flush();*/
           response.getWriter().write(jsonString);
           return false;
       }
        BaseContextUtil.setCurrentId(employeeId);//待会这里尝试设置用户共享字段
        return true;
        /*if(userId==null)//res.data.code === 0 && res.data.msg === 'NOTLOGIN'
        {//用户
            R<Employee> error = R.error("NOTLOGIN");
            String jsonString = JSON.toJSONString(error);
            response.getWriter().write(jsonString);
            return false;
        }*/
        //BaseContextUtil.setCurrentId(userId);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
