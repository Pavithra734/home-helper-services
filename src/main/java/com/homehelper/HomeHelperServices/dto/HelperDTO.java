package com.homehelper.HomeHelperServices.dto;

public class HelperDTO {

    private int helper_id;
    private String name;
    private String email;
    private String phone;
    private String service;
    private String availability;

    public HelperDTO() {
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