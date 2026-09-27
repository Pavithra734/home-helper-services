package com.homehelper.HomeHelperServices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homehelper.HomeHelperServices.entity.Helper;

public interface HelperRepository extends JpaRepository<Helper, Integer> {

    Optional<Helper> findByEmail(String email);
}