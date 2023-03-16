package DatabaseWebApp.mainSrcCode.TestingCode;

import DatabaseWebApp.mainSrcCode.WebAppWithDB;
import DatabaseWebApp.mainSrcCode.domain.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TestDatabaseConnection {
    private static String currentDatabase = "web_customer_tracker";
    private static String port = "3307";

    private static String user = "springstudent";
    private static String pass = "springstudent";
    private static Class<Customer> customerClass = Customer.class;

    public static void main(String[] args) {
        Session session = HibernateUtil.getCurrentSession();
        System.out.println("OKAY");
        try {
            // begin transaction
            session.beginTransaction();
            Customer savedCustomer = new Customer("Leo","Messi","leo@wc.com");
            session.save(savedCustomer);
            int id = 1;
            Customer customer = session.get(Customer.class,id);

            System.out.println(customer);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }


}
