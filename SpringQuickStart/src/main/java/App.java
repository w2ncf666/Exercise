import com.wcf.config.SpringConfig;
import com.wcf.text.textBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
        textBean textBean= (textBean) ctx.getBean("textBean");
        textBean.setName("温超凡");
        textBean.eat(textBean.getPeople());
        System.out.println(textBean);
        textBean textBean2= (textBean) ctx.getBean("textBean");
        textBean2.setName("黄石东");
        System.out.println("555555");
        System.out.println(textBean.getGender());
        int ret=textBean.eat(textBean.getPeople());
        System.out.println(textBean.text);
        System.out.println(ret+"返回值");
        textBean2.eat(textBean2.getPeople());
        ctx.close();
        System.out.println(textBean.getClass());
        System.out.println(textBean2);
        textBean2.text=2;
        System.out.println(textBean2.text);
    }
}
