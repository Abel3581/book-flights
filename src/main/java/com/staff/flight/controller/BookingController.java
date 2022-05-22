package com.staff.flight.controller;


import com.staff.flight.model.request.BookingRequest;
import com.staff.flight.model.response.BookingResponse;
import com.staff.flight.service.abstraction.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/save")
    public ResponseEntity<BookingResponse> save(@Valid @RequestBody BookingRequest request)
   {
        BookingResponse response = bookingService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
