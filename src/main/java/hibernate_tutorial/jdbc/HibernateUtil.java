package hibernate_tutorial.jdbc;

import hibernate_tutorial.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static Session getSession(String concreteDatabase, Class<?> annotatedClass) {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration()
                    .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3307/" + concreteDatabase)
                    .setProperty("hibernate.connection.username", "hbstudent")
                    .setProperty("hibernate.connection.password", "hbstudent")
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect")
                    .setProperty("hibernate.show_sql", "true")
                    .addAnnotatedClass(annotatedClass); // add your entity classes here

            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory.openSession();
    }
}





