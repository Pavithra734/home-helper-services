package com.homehelper.HomeHelperServices.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.homehelper.HomeHelperServices.entity.Payment;
import com.homehelper.HomeHelperServices.exception.BookingNotFoundException;
import com.homehelper.HomeHelperServices.exception.PaymentNotFoundException;
import com.homehelper.HomeHelperServices.repository.BookingRepository;
import com.homehelper.HomeHelperServices.repository.PaymentRepository;
import com.homehelper.HomeHelperServices.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final BookingRepository bookingRepository;

    public PaymentServiceImpl(
            PaymentRepository paymentRepository,
            BookingRepository bookingRepository) {

        this.paymentRepository = paymentRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Payment createPayment(Payment payment) {

        if (payment.getBooking() == null ||
                payment.getBooking().getBooking_id() == 0) {
            throw new BookingNotFoundException("Booking is required");
        }

        int bookingId = payment.getBooking().getBooking_id();

        var booking = bookingRepository.findById(bookingId)
                .orElseThrow(() ->
                        new BookingNotFoundException("Booking not found"));

        payment.setBooking(booking);

        if (payment.getPayment_status() == null ||
                payment.getPayment_status().isEmpty()) {
            payment.setPayment_status("PENDING");
        }

        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(int id) {

        return paymentRepository.findById(id)
                .orElseThrow(() ->
                        new PaymentNotFoundException("Payment not found"));
    }

    @Override
    public Payment getPaymentByBooking(int bookingId) {

        bookingRepository.findById(bookingId)
                .orElseThrow(() ->
                        new BookingNotFoundException("Booking not found"));

        return paymentRepository.findByBookingId(bookingId)
                .orElseThrow(() ->
                        new PaymentNotFoundException("Payment not found"));
    }

    @Override
    public Payment updatePayment(int id, Payment payment) {

        Payment existing = getPaymentById(id);

        existing.setAmount(payment.getAmount());
        existing.setPayment_date(payment.getPayment_date());
        existing.setPayment_status(payment.getPayment_status());
        existing.setPayment_method(payment.getPayment_method());
        existing.setTransaction_id(payment.getTransaction_id());

        return paymentRepository.save(existing);
    }
}