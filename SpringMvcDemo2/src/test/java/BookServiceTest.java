import com.wcf.config.SpringConfig;
import com.wcf.pojo.Book;
import com.wcf.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class BookServiceTest {
    @Autowired
    private BookService bookService;

@Test
    public void textGetById(){
        Book book= bookService.getById(2);
        System.out.println(book);
    }

    @Test
    public void textGetAll(){
        List<Book> book= bookService.getAll();
        System.out.println(book);
    }
}