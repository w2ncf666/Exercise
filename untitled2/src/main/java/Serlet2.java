import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/6")
public class Serlet2 extends HttpServlet {
    @Override//doGet是请求参数在请求行中,即拼接在url后面
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("测试机");//记住了:HttpServletRequest req   HttpServletRequest是接口,rep是实现类,可以用匿名内部类
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
        super.doPost(req, resp);
    }
}
