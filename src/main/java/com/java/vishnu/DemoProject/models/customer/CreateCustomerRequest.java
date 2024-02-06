package com.java.vishnu.DemoProject.models.customer;

import com.java.vishnu.DemoProject.models.permission.Permission;
import jakarta.persistence.Column;

import java.util.List;

public class CreateCustomerRequest {
    private Long id;
    private String name;
    private String organisation;
    private String country;
    private String state;
    private String description;
    private String tradeMark;
    private List<Permission> permissions;

    public CreateCustomerRequest(Long id, String name, String organisation,
                                 String country, String state, String description,
                                 String tradeMark, List<Permission> permissions) {
        this.id = id;
        this.name = name;
        this.organisation = organisation;
        this.country = country;
        this.state = state;
        this.description = description;
        this.tradeMark = tradeMark;
        this.permissions = permissions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTradeMark() {
        return tradeMark;
    }

    public void setTradeMark(String tradeMark) {
        this.tradeMark = tradeMark;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}