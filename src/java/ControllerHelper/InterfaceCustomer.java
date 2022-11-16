package ControllerHelper;

import Model.Customer;
import Model.UserCredentials;
import java.util.List;

public interface InterfaceCustomer {

    public Customer validateCustomer(UserCredentials customer);

    public int insertCustomer(Customer customer);

    public List<Customer> getAllCustomers();

    public Customer selectCustomer(int id);

    public int deleteCustomer(int id);

    public int updateCustomer(Customer customer);

    public int CountCustomer();
    
    public String getCustomerName(int id);

}
