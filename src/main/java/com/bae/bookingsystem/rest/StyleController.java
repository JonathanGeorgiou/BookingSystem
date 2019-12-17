package com.bae.bookingsystem.rest;

import javax.validation.Valid;

import com.bae.bookingsystem.persistance.domain.Style;

import com.bae.bookingsystem.service.StyleService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

// import com.fasterxml.jackson.annotation.JsonAnyGetter;

import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestParam;

/**
 * BookingController
 */
@RestController
@RequestMapping
public class StyleController {

    private StyleService styleService;

    public StyleController(StyleService styleService) {
        this.styleService = styleService;
    }

    @PostMapping("/createStyle")
    public Style postStyle(@RequestBody @Valid Style style) {
        return this.styleService.createStyle(style);
    }
}