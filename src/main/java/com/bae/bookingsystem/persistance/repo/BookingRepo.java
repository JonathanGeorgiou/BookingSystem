package com.bae.bookingsystem.persistance.repo;

import com.bae.bookingsystem.persistance.domain.Booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * BookingRepo
 */
@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {

}