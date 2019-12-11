package com.bae.bookingsystem.persistance.repo;

import com.bae.bookingsystem.persistance.domain.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepo
 */
@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {
}