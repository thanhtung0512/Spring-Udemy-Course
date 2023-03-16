package DatabaseWebApp.mainSrcCode.dao;

import DatabaseWebApp.mainSrcCode.domain.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional // auto begin and commit transaction
    public List<Customer> getCustomers() {
        Session session = sessionFactory.openSession();
        List<Customer> customerList = session.createQuery("FROM customer", Customer.class).getResultList();
        return customerList;
    }
}
