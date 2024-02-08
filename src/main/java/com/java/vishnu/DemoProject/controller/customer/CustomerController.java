package com.java.vishnu.DemoProject.controller.customer;

import com.java.vishnu.DemoProject.exceptions.UserNotFoundException;
import com.java.vishnu.DemoProject.models.customer.CreateCustomerRequest;
import com.java.vishnu.DemoProject.models.customer.Customer;
import com.java.vishnu.DemoProject.models.customer.UpdateCustomerRequest;
import com.java.vishnu.DemoProject.models.user.UpdateUserRequest;
import com.java.vishnu.DemoProject.models.user.User;
import com.java.vishnu.DemoProject.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Customer>> getAllCustomers(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String organisation,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String state,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String tradeMark) {
        List<Customer> customers= customerService.getAllCustomer(id,name,organisation,country,state,description,tradeMark);
        return new ResponseEntity<>(customers, HttpStatus.OK);

    }

    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody UpdateCustomerRequest updateCustomerRequest) {
        return customerService.updateCustomer(id, updateCustomerRequest);
    }
}