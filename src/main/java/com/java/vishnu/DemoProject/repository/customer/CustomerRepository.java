package com.java.vishnu.DemoProject.repository.customer;

import com.java.vishnu.DemoProject.models.customer.Customer;
import com.java.vishnu.DemoProject.models.user.User;

import java.util.List;

public interface CustomerRepository {
    Customer createCustomer(Customer customer);

    Customer getCustomerById(Long id);

    void deletedCustomerById(Long id);

    List<Customer> getAllCustomer();

    Customer updateCustomer(Customer customer);

}
