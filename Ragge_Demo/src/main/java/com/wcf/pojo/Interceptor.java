package com.wcf.pojo;

import com.alibaba.fastjson.JSON;
import com.wcf.Util.BaseContextUtil;
import com.wcf.reastic.Employee;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class Interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
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
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
