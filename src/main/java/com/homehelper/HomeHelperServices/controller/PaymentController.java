package com.homehelper.HomeHelperServices.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homehelper.HomeHelperServices.entity.Payment;
import com.homehelper.HomeHelperServices.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.createPayment(payment);
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public Payment getPayment(@PathVariable int id) {
        return paymentService.getPaymentById(id);
    }

    @GetMapping("/booking/{bookingId}")
    public Payment getPaymentByBooking(
            @PathVariable int bookingId) {

        return paymentService.getPaymentByBooking(bookingId);
    }

    @PutMapping("/{id}")
    public Payment updatePayment(
            @PathVariable int id,
            @RequestBody Payment payment) {

        return paymentService.updatePayment(id, payment);
    }
}