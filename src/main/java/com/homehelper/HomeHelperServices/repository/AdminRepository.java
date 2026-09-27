package com.homehelper.HomeHelperServices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homehelper.HomeHelperServices.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Optional<Admin> findByEmail(String email);
}