package com.homehelper.HomeHelperServices.serviceimpl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.homehelper.HomeHelperServices.entity.Admin;
import com.homehelper.HomeHelperServices.entity.Booking;
import com.homehelper.HomeHelperServices.entity.Customer;
import com.homehelper.HomeHelperServices.entity.Helper;
import com.homehelper.HomeHelperServices.entity.Payment;
import com.homehelper.HomeHelperServices.exception.BookingNotFoundException;
import com.homehelper.HomeHelperServices.exception.CustomerNotFoundException;
import com.homehelper.HomeHelperServices.exception.HelperNotFoundException;
import com.homehelper.HomeHelperServices.exception.PaymentNotFoundException;
import com.homehelper.HomeHelperServices.repository.AdminRepository;
import com.homehelper.HomeHelperServices.repository.BookingRepository;
import com.homehelper.HomeHelperServices.repository.CustomerRepository;
import com.homehelper.HomeHelperServices.repository.HelperRepository;
import com.homehelper.HomeHelperServices.repository.PaymentRepository;
import com.homehelper.HomeHelperServices.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final CustomerRepository customerRepository;
    private final HelperRepository helperRepository;
    private final BookingRepository bookingRepository;
    private final PaymentRepository paymentRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminServiceImpl(
            AdminRepository adminRepository,
            CustomerRepository customerRepository,
            HelperRepository helperRepository,
            BookingRepository bookingRepository,
            PaymentRepository paymentRepository,
            PasswordEncoder passwordEncoder) {

        this.adminRepository = adminRepository;
        this.customerRepository = customerRepository;
        this.helperRepository = helperRepository;
        this.bookingRepository = bookingRepository;
        this.paymentRepository = paymentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Admin login(String email, String password) {

        Admin admin = adminRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(password, admin.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        return admin;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
    }

    @Override
    public List<Helper> getAllHelpers() {
        return helperRepository.findAll();
    }

    @Override
    public Helper getHelperById(int id) {
        return helperRepository.findById(id)
                .orElseThrow(() -> new HelperNotFoundException("Helper not found"));
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(int id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new BookingNotFoundException("Booking not found"));
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(int id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException("Payment not found"));
    }
}