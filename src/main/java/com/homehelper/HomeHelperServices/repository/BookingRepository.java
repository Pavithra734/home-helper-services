package com.homehelper.HomeHelperServices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.homehelper.HomeHelperServices.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    @Query("SELECT b FROM Booking b WHERE b.customer.customer_id = :customerId")
    List<Booking> findByCustomerId(@Param("customerId") int customerId);

    @Query("SELECT b FROM Booking b WHERE b.helper.helper_id = :helperId")
    List<Booking> findBookingsByHelperId(@Param("helperId") int helperId);
}