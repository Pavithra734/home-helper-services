package com.homehelper.HomeHelperServices.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public String handleCustomerNotFound(CustomerNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(HelperNotFoundException.class)
    public String handleHelperNotFound(HelperNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(BookingNotFoundException.class)
    public String handleBookingNotFound(BookingNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(PaymentNotFoundException.class)
    public String handlePaymentNotFound(PaymentNotFoundException ex) {
        return ex.getMessage();
    }
}