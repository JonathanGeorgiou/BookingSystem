package com.bae.bookingsystem.service;

import com.bae.bookingsystem.persistance.domain.Style;

import com.bae.bookingsystem.persistance.repo.StyleRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * BookingService
 */
@Service
public class StyleService {

    @Autowired
    private StyleRepo styleRepo;

    public Style createStyle(Style style) {
        return styleRepo.save(style);
    }

}