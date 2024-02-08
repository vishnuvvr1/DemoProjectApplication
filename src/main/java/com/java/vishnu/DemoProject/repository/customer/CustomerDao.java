package com.java.vishnu.DemoProject.repository.customer;

import com.java.vishnu.DemoProject.models.customer.Customer;
import com.java.vishnu.DemoProject.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface CustomerDao  extends JpaRepository<Customer,Long> {
    List<Customer> findAllByName(String name);

    List<Customer> findAllByOrganisation(String organisation);

    List<Customer> findAllByCountry(String country);

    List<Customer> findAllByState(String state);

    List<Customer> findAllByDescription(String description);

    List<Customer> findAllByTradeMark(String tradeMark);
}