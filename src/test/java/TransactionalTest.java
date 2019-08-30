import com.example.lihuan.demo.Application;
import com.example.lihuan.demo.entity.User;
import com.example.lihuan.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TransactionalTest
{
    @Autowired
    private UserService userService;

    @Test
    public void test()
    {
        User user = new User();
        user.setId(100);
        userService.addUser(user);
    }
}
