package com.java.vishnu.DemoProject.repository.customer;

import com.java.vishnu.DemoProject.models.customer.Customer;
import com.java.vishnu.DemoProject.models.user.User;

import java.util.List;

public interface CustomerRepository {
    Customer createCustomer(Customer customer);

    Customer getCustomerById(Long id);


    List<Customer> getAllCustomer(Long id, String name, String organisation, String country, String state, String description, String tradeMark);

    Customer updateCustomer(Customer customer);

    void deleteCustomerById(Long id);
}

