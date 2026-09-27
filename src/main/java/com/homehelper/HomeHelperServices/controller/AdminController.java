package com.homehelper.HomeHelperServices.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homehelper.HomeHelperServices.entity.Admin;
import com.homehelper.HomeHelperServices.entity.Booking;
import com.homehelper.HomeHelperServices.entity.Customer;
import com.homehelper.HomeHelperServices.entity.Helper;
import com.homehelper.HomeHelperServices.entity.Payment;
import com.homehelper.HomeHelperServices.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/login")
    public Admin login(@RequestBody Admin admin) {

        return adminService.login(
                admin.getEmail(),
                admin.getPassword());
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return adminService.getAllCustomers();
    }

    @GetMapping("/helpers")
    public List<Helper> getHelpers() {
        return adminService.getAllHelpers();
    }

    @GetMapping("/bookings")
    public List<Booking> getBookings() {
        return adminService.getAllBookings();
    }

    @GetMapping("/payments")
    public List<Payment> getPayments() {
        return adminService.getAllPayments();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable int id) {
        return adminService.getCustomerById(id);
    }

    @GetMapping("/helpers/{id}")
    public Helper getHelper(@PathVariable int id) {
        return adminService.getHelperById(id);
    }

    @GetMapping("/bookings/{id}")
    public Booking getBooking(@PathVariable int id) {
        return adminService.getBookingById(id);
    }

    @GetMapping("/payments/{id}")
    public Payment getPayment(@PathVariable int id) {
        return adminService.getPaymentById(id);
    }
}