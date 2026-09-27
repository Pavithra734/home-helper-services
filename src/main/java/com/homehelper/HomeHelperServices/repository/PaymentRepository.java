package com.homehelper.HomeHelperServices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.homehelper.HomeHelperServices.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @Query("SELECT p FROM Payment p WHERE p.booking.booking_id = :bookingId")
    Optional<Payment> findByBookingId(@Param("bookingId") int bookingId);

}