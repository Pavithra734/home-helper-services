package com.homehelper.HomeHelperServices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homehelper.HomeHelperServices.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByEmail(String email);
}