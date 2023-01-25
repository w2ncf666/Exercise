import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@WebServlet("/sd")
public class Serlet2 extends HttpServlet {
    @Override//doGet是请求参数在请求行中,即拼接在url后面
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("测试机");
        req.setCharacterEncoding("UTF-8");
        System.out.println(req.getRequestURI());
        Map<String, String[]> map = req.getParameterMap();
        for (String s : map.keySet()) {
            String[] value = map.get(s);
            for (String s1 : value) {
                System.out.println(s1);
            }
        }
        System.out.println("---------------");
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }
        System.out.println("----------------");
        String username = req.getParameter("username");

        System.out.println("乱码前 "+username);
        username=new String(username.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        System.out.println("改完后"+username);
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath+"/servlet");
        //req.getRequestDispatcher("servlet").forward(req,resp);//request请求转发
        //记住了:HttpServletRequest req   HttpServletRequest是接口,rep是实现类,可以用匿名内部类
        /*                                                 2023.1.19.23:41:25                    其实就是匿名内部类中的知识
        *
        * 前端发送GET和POST请求的时候，参数的位置不一致，GET请求参数在请求行中，POST请求参数在请求体中==，为了能处理不同的请求方式，我们得在
        * service方法中进行判断，然后写不同的业务处理，这样能实现，但是每个Servlet类中都将有相似的代码，针对这个问题，Java原码写了HttpServlet
        * 这个父类写了doGet和doPost方法
        *
        * */
    }

    @Override//doGet是请求参数在请求体中,
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post...");
        this.doGet(req,resp);
    }
}
