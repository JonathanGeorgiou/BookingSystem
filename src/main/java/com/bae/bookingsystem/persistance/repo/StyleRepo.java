package com.bae.bookingsystem.persistance.repo;

import com.bae.bookingsystem.persistance.domain.Style;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ServicesRepo
 */
@Repository
public interface StyleRepo extends JpaRepository<Style, Long> {
    
    
}