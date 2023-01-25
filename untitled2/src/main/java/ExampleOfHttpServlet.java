
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
/*
* 这个类是模拟HttpServlet原码doPost 和 doGet  都是从service方法中抽取出来为他服务的
*HttpServlet接口继承自Servlet接口
* 相当于当前ExampleOfHttpServlet 继承自Servlet接口
* */
public class ExampleOfHttpServlet extends Servlet {
    public void init(ServletConfig config) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        //1. 获取请求方式
        String method = request.getMethod();
        //2. 判断
        if("GET".equals(method)){
            // get方式的处理逻辑
            doGet(req,res);
        }else if("POST".equals(method)){
            // post方式的处理逻辑
            doPost(req,res);
        }
    }

    protected void doPost(ServletRequest req, ServletResponse res) {
    }

    protected void doGet(ServletRequest req, ServletResponse res) {
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}