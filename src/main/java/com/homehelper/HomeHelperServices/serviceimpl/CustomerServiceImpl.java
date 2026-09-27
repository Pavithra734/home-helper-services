package com.homehelper.HomeHelperServices.serviceimpl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.homehelper.HomeHelperServices.entity.Booking;
import com.homehelper.HomeHelperServices.entity.Customer;
import com.homehelper.HomeHelperServices.exception.CustomerNotFoundException;
import com.homehelper.HomeHelperServices.repository.BookingRepository;
import com.homehelper.HomeHelperServices.repository.CustomerRepository;
import com.homehelper.HomeHelperServices.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final BookingRepository bookingRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomerServiceImpl(
            CustomerRepository customerRepository,
            BookingRepository bookingRepository,
            PasswordEncoder passwordEncoder) {

        this.customerRepository = customerRepository;
        this.bookingRepository = bookingRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Customer registerCustomer(Customer customer) {

        customer.setPassword(passwordEncoder.encode(customer.getPassword()));

        return customerRepository.save(customer);
    }

    @Override
    public Customer login(String email, String password) {

        Customer customer = customerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(password, customer.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(int id) {

        return customerRepository.findById(id)
                .orElseThrow(() ->
                        new CustomerNotFoundException("Customer not found"));
    }

    @Override
    public Customer updateCustomer(int id, Customer customer) {

        Customer existing = customerRepository.findById(id)
                .orElseThrow(() ->
                        new CustomerNotFoundException("Customer not found"));

        existing.setName(customer.getName());
        existing.setEmail(customer.getEmail());
        existing.setPhone(customer.getPhone());
        existing.setAddress(customer.getAddress());

        if (customer.getPassword() != null && !customer.getPassword().isEmpty()) {
            existing.setPassword(passwordEncoder.encode(customer.getPassword()));
        }

        return customerRepository.save(existing);
    }

    @Override
    public void deleteCustomer(int id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() ->
                        new CustomerNotFoundException("Customer not found"));

        customerRepository.delete(customer);
    }

    @Override
    public List<Booking> getCustomerBookings(int customerId) {

        customerRepository.findById(customerId)
                .orElseThrow(() ->
                        new CustomerNotFoundException("Customer not found"));

        return bookingRepository.findBookingsByHelperId(customerId);
    }
}