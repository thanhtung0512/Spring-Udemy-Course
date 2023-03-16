package DatabaseWebApp.mainSrcCode;

import DatabaseWebApp.mainSrcCode.TestingCode.HibernateUtil;
import DatabaseWebApp.mainSrcCode.domain.Customer;
import com.example.springmvcdemo.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class WebAppWithDB {

    private static Session session;

    private static void log(Object object) {
        System.out.println(object.toString());
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(WebAppWithDB.class,args);
        SessionFactory sessionFactory = context.getBean("getSessionFactory",SessionFactory.class);
        Session session = sessionFactory.openSession();
//        Session session = HibernateUtil.getCurrentSession();
        try {
            session.beginTransaction();
            int id = 1;
            Customer customer = session.get(Customer.class, id);
            log(customer);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @GetMapping("/secondIndex")
    public String index() {
        return "index1";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "registerForm";
    }

}
