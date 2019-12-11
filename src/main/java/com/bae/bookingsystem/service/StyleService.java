package com.bae.bookingsystem.service;

import com.bae.bookingsystem.persistance.repo.StyleRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * StyleService
 */
@Service
public class StyleService {

    @Autowired
    private StyleRepo styleRepo;
    
}