package DatabaseWebApp.mainSrcCode.TestingCode;


import DatabaseWebApp.mainSrcCode.domain.Customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TestDatabaseConnection {
    private static String currentDatabase = "web_customer_tracker";
    private static String port = "3307";

    private static String user = "springstudent";
    private static String pass = "springstudent";
    private static Class<Customer> customerClass = Customer.class;

    public static void main(String[] args) {
        SpringApplication.run(TestDatabaseConnection.class,args);

    }


}
