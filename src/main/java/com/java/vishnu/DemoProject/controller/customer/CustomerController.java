package com.java.vishnu.DemoProject.controller.customer;

import ch.qos.logback.core.model.Model;
import com.java.vishnu.DemoProject.exceptions.UserNotFoundException;
import com.java.vishnu.DemoProject.models.customer.CreateCustomerRequest;
import com.java.vishnu.DemoProject.models.customer.Customer;
import com.java.vishnu.DemoProject.models.customer.UpdateCustomerRequest;
import com.java.vishnu.DemoProject.service.customer.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Customer Controller", description = "Manage Customers In Demo API")
public class CustomerController {

    @Autowired
    public CustomerController(@Qualifier("customerService") CustomerService customerService){
        this.customerService=customerService;
    }
    private CustomerService customerService;
    @ModelAttribute("appName")
    public String commonAttributes() {
        return "Demo Project";
    }
    @PostMapping("/customers")
    @Operation(summary = "Create Customers", responses = {@ApiResponse(description = "OK",
            responseCode = "201",
            content = @Content(schema = @Schema(implementation = CreateCustomerRequest.class)))
    })
    public Customer createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) {
        return customerService.createcustomer(createCustomerRequest);
    }

    @GetMapping("/customers/{id}")
    @Operation(summary = "Get Customer By Id", responses = {@ApiResponse(description = "Ok", responseCode = "200",
            content = @Content(schema = @Schema(implementation = Customer.class)))
    })
    public Customer getCustomerById(@PathVariable Long id) throws UserNotFoundException {
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("/customers/{id}")
    @Operation(summary = "Delete Customer By Id", responses = {@ApiResponse(description = "Ok", responseCode = "200",
            content = @Content(schema = @Schema(implementation = void.class)))
    })
    public String deleteCustomerById(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
        return "deleted by id ";
    }

    @GetMapping("/customers")
    @Operation(summary = "List All Customers", responses = {@ApiResponse(description = "Ok", responseCode = "200",
            content = @Content(schema = @Schema(implementation = void.class)))
    })
    public ResponseEntity<List<Customer>> getAllCustomers(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String organisation,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String state,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String tradeMark) {
        List<Customer> customers = customerService.getAllCustomer(id, name, organisation, country, state, description, tradeMark);
        return new ResponseEntity<>(customers, HttpStatus.OK);

    }

    @PutMapping("/customers/{id}")
    @Operation(summary = "Update Customers", responses = {@ApiResponse(description = "Ok", responseCode = "200",
            content = @Content(schema = @Schema(implementation = UpdateCustomerRequest.class)))
    })

    public Customer updateCustomer(@PathVariable Long id, @RequestBody UpdateCustomerRequest updateCustomerRequest) {
        return customerService.updateCustomer(id, updateCustomerRequest);
    }
}