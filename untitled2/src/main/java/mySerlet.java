import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
@WebServlet(urlPatterns = "/demo1",loadOnStartup = 1)
public class mySerlet extends Servlet {
    private ServletConfig servletConfig;
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("666666");//只会初始化一次
        this.servletConfig=servletConfig;
        /**
         *  初始化方法
         *  1.调用时机：默认情况下，Servlet被第一次访问时，调用
         *      * loadOnStartup: 默认为-1，修改为0或者正整数，则会在服务器启动的时候，调用
         *  2.调用次数: 1次
         * @param config
         * @throws ServletException
         */
    }

    public ServletConfig getServletConfig() {

        return servletConfig;//ServletConfig对象，在init方法的参数中有，而Tomcat Web服务器在创建Servlet对象的时候会调用init方法，
        // 必定会传入一个ServletConfig对象，我们只需要将服务器传过来的ServletConfig进行返回即可
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("服务方法");//加载一次执行一次
    }

    public String getServletInfo() {
        return null;//该方法用来返回Servlet的相关信息，没有什么太大的用处，一般我们返回一个空字符串即可
    }

    public void destroy() {
/**
 * 销毁方法
 * 1.调用时机：内存释放或者服务器关闭的时候，Servlet对象会被销毁，调用
 * 2.调用次数: 1次
 */
    }
}
