package com.homehelper.HomeHelperServices.service;

import java.util.List;

import com.homehelper.HomeHelperServices.entity.Booking;

public interface BookingService {

    Booking createBooking(Booking booking);

    List<Booking> getAllBookings();

    Booking getBookingById(int id);

    List<Booking> getBookingsByCustomer(int customerId);

    List<Booking> getBookingsByHelper(int helperId);

    Booking updateBooking(int id, Booking booking);

    Booking updateBookingStatus(int id, String status);

    void deleteBooking(int id);
}