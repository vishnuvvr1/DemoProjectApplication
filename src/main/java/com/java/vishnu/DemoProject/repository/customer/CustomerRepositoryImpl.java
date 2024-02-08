package com.java.vishnu.DemoProject.repository.customer;

import com.java.vishnu.DemoProject.models.customer.Customer;
import com.java.vishnu.DemoProject.models.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
    public List<Customer> getAllCustomer(Long id, String name, String organisation, String country, String state, String description, String tradeMark) {
        List<Customer> customers = new ArrayList<>();
        if (id != null){
            customers.add(customerDao.findById(id).get());
            return customers;
        }
        if (name != null){
            return  customerDao.findAllByName(name);
        }
        if (organisation != null){
            return  customerDao.findAllByOrganisation(organisation);
        }
        if (country != null){
            return  customerDao.findAllByCountry(country);
        }
        if (state != null){
            return  customerDao.findAllByState(state);
        }
        if (description != null){
            return  customerDao.findAllByDescription(description);
        }
        if (tradeMark != null){
            return  customerDao.findAllByTradeMark(tradeMark);
        }

        return customerDao.findAll();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerDao.save(customer);
    }

}
