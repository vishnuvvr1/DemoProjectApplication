package com.java.vishnu.DemoProject.service.customer;

import com.java.vishnu.DemoProject.exceptions.UserNotFoundException;
import com.java.vishnu.DemoProject.models.customer.CreateCustomerRequest;
import com.java.vishnu.DemoProject.models.customer.Customer;
import com.java.vishnu.DemoProject.models.customer.UpdateCustomerRequest;
import com.java.vishnu.DemoProject.models.user.User;
import com.java.vishnu.DemoProject.repository.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpI implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Customer createcustomer(CreateCustomerRequest createCustomerRequest) {
        Customer customer = new Customer();
        customer.setName(createCustomerRequest.getName());
        customer.setDescription(createCustomerRequest.getDescription());
        customer.setCountry(createCustomerRequest.getCountry());
        customer.setState(createCustomerRequest.getState());
        customer.setOrganisation(createCustomerRequest.getOrganisation());
        customer.setTradeMark(createCustomerRequest.getTradeMark());
        customer.setPermission(createCustomerRequest.getPermissions());
        return customerRepository.createCustomer(customer);
    }

    @Override
    public Customer getCustomerById(Long id) throws UserNotFoundException {
        Customer customer= customerRepository.getCustomerById(id);
        if (customer == null){
            throw  new UserNotFoundException("id not found : " + id);
        }
        return  customerRepository.getCustomerById(id);
    }

    @Override
    public void deleteCustomerById(Long id) {

        customerRepository.deletedCustomerById(id);
    }

    @Override
    public List<Customer> getAllCustomer(Long id, String name, String organisation, String country, String state, String description, String tradeMark) {
        return customerRepository.getAllCustomer(id,name,organisation,country,state,description,tradeMark);
    }

    @Override
    public Customer updateCustomer(Long id, UpdateCustomerRequest updateCustomerRequest) {
        Customer customer = customerRepository.getCustomerById(id);
        customer.setOrganisation(updateCustomerRequest.getOrganisation());
        customer.setCountry(updateCustomerRequest.getCountry());
        customer.setState(updateCustomerRequest.getState());
        customer.setDescription(updateCustomerRequest.getDescription());
        customer.setTradeMark(updateCustomerRequest.getTradeMark());
        return customerRepository.updateCustomer(customer);
    }
}
