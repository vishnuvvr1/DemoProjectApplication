package com.java.vishnu.DemoProject.repository.customer;

import com.java.vishnu.DemoProject.models.customer.Customer;
import com.java.vishnu.DemoProject.models.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @Autowired
    private CustomerDao customerDao;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerDao.save(customer);

    }

    @Override
    public Customer getCustomerById(Long id) {

        return customerDao.findById(id).orElse(null);
    }

    @Override
    public void deletedCustomerById(Long id) {
        customerDao.deleteById(id);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerDao.findAll();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerDao.save(customer);
    }

}
