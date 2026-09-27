package com.homehelper.HomeHelperServices.service;

import java.util.List;

import com.homehelper.HomeHelperServices.entity.Admin;
import com.homehelper.HomeHelperServices.entity.Booking;
import com.homehelper.HomeHelperServices.entity.Customer;
import com.homehelper.HomeHelperServices.entity.Helper;
import com.homehelper.HomeHelperServices.entity.Payment;

public interface AdminService {

    Admin login(String email, String password);

    List<Customer> getAllCustomers();

    Customer getCustomerById(int id);

    List<Helper> getAllHelpers();

    Helper getHelperById(int id);

    List<Booking> getAllBookings();

    Booking getBookingById(int id);

    List<Payment> getAllPayments();

    Payment getPaymentById(int id);
}