package com.homehelper.HomeHelperServices.service;

import java.util.List;

import com.homehelper.HomeHelperServices.entity.Payment;

public interface PaymentService {

    Payment createPayment(Payment payment);

    List<Payment> getAllPayments();

    Payment getPaymentById(int id);

    Payment getPaymentByBooking(int bookingId);

    Payment updatePayment(int id, Payment payment);
}