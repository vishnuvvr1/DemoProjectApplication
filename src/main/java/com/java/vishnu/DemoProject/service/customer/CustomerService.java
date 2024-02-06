package com.java.vishnu.DemoProject.service.customer;

import com.java.vishnu.DemoProject.exceptions.UserNotFoundException;
import com.java.vishnu.DemoProject.models.customer.CreateCustomerRequest;
import com.java.vishnu.DemoProject.models.customer.Customer;
import com.java.vishnu.DemoProject.models.customer.UpdateCustomerRequest;
import com.java.vishnu.DemoProject.models.user.User;

import java.util.List;

public interface CustomerService {
    Customer createcustomer(CreateCustomerRequest createCustomerRequest);

    Customer getCustomerById(Long id) throws UserNotFoundException;

    void deleteCustomerById(Long id);

    List<Customer> getAllCustomer();

    Customer updateCustomer(Long id, UpdateCustomerRequest updateCustomerRequest);

}
