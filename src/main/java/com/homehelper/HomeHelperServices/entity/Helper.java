package com.homehelper.HomeHelperServices.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Helper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int helper_id;

    private String name;
    private String email;
    private String password;
    private String phone;
    private String service;
    private String availability;

    public Helper() {
    }

    public int getHelper_id() {
        return helper_id;
    }

    public void setHelper_id(int helper_id) {
        this.helper_id = helper_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}