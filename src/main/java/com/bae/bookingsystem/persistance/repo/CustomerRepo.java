package com.bae.bookingsystem.persistance.repo;

import com.bae.bookingsystem.persistance.domain.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepo
 */
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
}