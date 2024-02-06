package com.java.vishnu.DemoProject.controller.customer;

import com.java.vishnu.DemoProject.exceptions.UserNotFoundException;
import com.java.vishnu.DemoProject.models.customer.CreateCustomerRequest;
import com.java.vishnu.DemoProject.models.customer.Customer;
import com.java.vishnu.DemoProject.models.customer.UpdateCustomerRequest;
import com.java.vishnu.DemoProject.models.user.UpdateUserRequest;
import com.java.vishnu.DemoProject.models.user.User;
import com.java.vishnu.DemoProject.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) {
        return customerService.createcustomer(createCustomerRequest);
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Long id)  throws UserNotFoundException {
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomerById(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
        return "deleted by id ";
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomer();

    }

    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody UpdateCustomerRequest updateCustomerRequest) {
        return customerService.updateCustomer(id, updateCustomerRequest);
    }
}