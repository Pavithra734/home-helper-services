package com.homehelper.HomeHelperServices.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.homehelper.HomeHelperServices.entity.Booking;
import com.homehelper.HomeHelperServices.exception.BookingNotFoundException;
import com.homehelper.HomeHelperServices.exception.CustomerNotFoundException;
import com.homehelper.HomeHelperServices.exception.HelperNotFoundException;
import com.homehelper.HomeHelperServices.repository.BookingRepository;
import com.homehelper.HomeHelperServices.repository.CustomerRepository;
import com.homehelper.HomeHelperServices.repository.HelperRepository;
import com.homehelper.HomeHelperServices.repository.PaymentRepository;
import com.homehelper.HomeHelperServices.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final CustomerRepository customerRepository;
    private final HelperRepository helperRepository;
    private final PaymentRepository paymentRepository;

    public BookingServiceImpl(
            BookingRepository bookingRepository,
            CustomerRepository customerRepository,
            HelperRepository helperRepository,
            PaymentRepository paymentRepository) {

        this.bookingRepository = bookingRepository;
        this.customerRepository = customerRepository;
        this.helperRepository = helperRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Booking createBooking(Booking booking) {

        if (booking.getCustomer() == null ||
                booking.getCustomer().getCustomer_id() == 0) {

            throw new CustomerNotFoundException("Customer is required");
        }

        if (booking.getHelper() == null ||
                booking.getHelper().getHelper_id() == 0) {

            throw new HelperNotFoundException("Helper is required");
        }

        int customerId = booking.getCustomer().getCustomer_id();
        int helperId = booking.getHelper().getHelper_id();

        var customer = customerRepository.findById(customerId)
                .orElseThrow(() ->
                        new CustomerNotFoundException("Customer not found"));

        var helper = helperRepository.findById(helperId)
                .orElseThrow(() ->
                        new HelperNotFoundException("Helper not found"));

        booking.setCustomer(customer);
        booking.setHelper(helper);

        if (booking.getBooking_status() == null ||
                booking.getBooking_status().isEmpty()) {

            booking.setBooking_status("PENDING");
        }

        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(int id) {
        return bookingRepository.findById(id)
                .orElseThrow(() ->
                        new BookingNotFoundException("Booking not found"));
    }

    @Override
    public List<Booking> getBookingsByCustomer(int customerId) {

        customerRepository.findById(customerId)
                .orElseThrow(() ->
                        new CustomerNotFoundException("Customer not found"));

        return bookingRepository.findByCustomerId(customerId);
    }

    @Override
    public List<Booking> getBookingsByHelper(int helperId) {

        helperRepository.findById(helperId)
                .orElseThrow(() ->
                        new HelperNotFoundException("Helper not found"));

        return bookingRepository.findBookingsByHelperId(helperId);
    }

    @Override
    public Booking updateBooking(int id, Booking booking) {

        Booking existing = getBookingById(id);

        existing.setService_type(booking.getService_type());
        existing.setBooking_date(booking.getBooking_date());
        existing.setBooking_time(booking.getBooking_time());
        existing.setAddress(booking.getAddress());
        existing.setBooking_status(booking.getBooking_status());
        existing.setCreated_date(booking.getCreated_date());

        return bookingRepository.save(existing);
    }

    @Override
    public Booking updateBookingStatus(int id, String status) {

        Booking existing = getBookingById(id);

        existing.setBooking_status(status);

        return bookingRepository.save(existing);
    }

    @Override
    public void deleteBooking(int id) {

        Booking booking = getBookingById(id);

        paymentRepository.findByBookingId(id)
                .ifPresent(paymentRepository::delete);

        bookingRepository.delete(booking);
    }
}