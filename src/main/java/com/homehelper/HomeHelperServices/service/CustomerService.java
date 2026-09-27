package com.homehelper.HomeHelperServices.service;

import java.util.List;

import com.homehelper.HomeHelperServices.entity.Booking;
import com.homehelper.HomeHelperServices.entity.Customer;

public interface CustomerService {

    Customer registerCustomer(Customer customer);

    Customer login(String email, String password);

    List<Customer> getAllCustomers();

    Customer getCustomerById(int id);

    Customer updateCustomer(int id, Customer customer);

    void deleteCustomer(int id);

    List<Booking> getCustomerBookings(int customerId);
}