package com.homehelper.HomeHelperServices.service;

public interface NotificationService {

    default String sendEmail(String email, String message) {
        return "Email notification sent to " + email;
    }

    default String sendSMS(String phone, String message) {
        return "SMS notification sent to " + phone;
    }
}