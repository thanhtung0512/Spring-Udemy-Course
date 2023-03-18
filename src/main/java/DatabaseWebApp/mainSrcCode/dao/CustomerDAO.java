package DatabaseWebApp.mainSrcCode.dao;

import DatabaseWebApp.mainSrcCode.domain.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers();

    void delete(int id);

    void add(Customer customer);


}
