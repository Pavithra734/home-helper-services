package com.homehelper.HomeHelperServices.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homehelper.HomeHelperServices.entity.Booking;
import com.homehelper.HomeHelperServices.entity.Customer;
import com.homehelper.HomeHelperServices.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public Customer register(@RequestBody Customer customer) {
        return customerService.registerCustomer(customer);
    }

    @PostMapping("/login")
    public Customer login(@RequestBody Customer customer) {
        return customerService.login(
                customer.getEmail(),
                customer.getPassword());
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(
            @PathVariable int id,
            @RequestBody Customer customer) {

        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable int id) {

        customerService.deleteCustomer(id);

        return "Customer deleted successfully";
    }

    @GetMapping("/{id}/bookings")
    public List<Booking> getCustomerBookings(@PathVariable int id) {
        return customerService.getCustomerBookings(id);
    }
}