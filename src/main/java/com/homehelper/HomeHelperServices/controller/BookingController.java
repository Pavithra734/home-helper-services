package com.homehelper.HomeHelperServices.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homehelper.HomeHelperServices.entity.Booking;
import com.homehelper.HomeHelperServices.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public Booking getBooking(@PathVariable int id) {
        return bookingService.getBookingById(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<Booking> getCustomerBookings(
            @PathVariable int customerId) {

        return bookingService.getBookingsByCustomer(customerId);
    }

    @GetMapping("/helper/{helperId}")
    public List<Booking> getHelperBookings(
            @PathVariable int helperId) {

        return bookingService.getBookingsByHelper(helperId);
    }

    @PutMapping("/{id}")
    public Booking updateBooking(
            @PathVariable int id,
            @RequestBody Booking booking) {

        return bookingService.updateBooking(id, booking);
    }

    @PutMapping("/{id}/status")
    public Booking updateStatus(
            @PathVariable int id,
            @RequestBody String status) {

        return bookingService.updateBookingStatus(
                id,
                status.replace("\"", ""));
    }

    @DeleteMapping("/{id}")
    public String deleteBooking(@PathVariable int id) {

        bookingService.deleteBooking(id);

        return "Booking deleted successfully";
    }
}