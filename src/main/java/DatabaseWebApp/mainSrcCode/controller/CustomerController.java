package DatabaseWebApp.mainSrcCode.controller;

import DatabaseWebApp.mainSrcCode.dao.CustomerDAO;
import DatabaseWebApp.mainSrcCode.domain.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @GetMapping("/list")
    public String listCustomers(Model model) {
        List<Customer> customerList = customerDAO.getCustomers();
        model.addAttribute("customers", customerList);
        return "list_customer";
    }

    @GetMapping("/add")
    public String addCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "add-customer";
    }

    @RequestMapping("/processAdding")
    public String processAdding( @ModelAttribute("customer") Customer customer) {

        System.out.println(customer.getFirstName() + " " + customer.getLastName() + " " + customer.getEmail());
        return "processAddingg";
    }
}
