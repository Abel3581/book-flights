package com.staff.flight.controller;


import com.staff.flight.entity.model.request.BookingRequest;
import com.staff.flight.entity.model.response.BookingResponse;
import com.staff.flight.service.abstraction.BookingService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.time.LocalDateTime;

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
