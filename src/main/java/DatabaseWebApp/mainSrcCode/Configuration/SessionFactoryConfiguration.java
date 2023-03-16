package DatabaseWebApp.mainSrcCode.Configuration;

import DatabaseWebApp.mainSrcCode.TestingCode.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SessionFactoryConfiguration {

    @Bean
    public SessionFactory getSessionFactory() {
        return HibernateUtil.getSessionFactory();
    }

}
