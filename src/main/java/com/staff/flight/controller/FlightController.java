package com.staff.flight.controller;

import com.staff.flight.entity.model.request.FlightRequest;
import com.staff.flight.entity.model.response.FlightResponse;
import com.staff.flight.service.abstraction.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/flight")
public class FlightController {

    private final FlightService flightService;
    @PostMapping("")
    public ResponseEntity<FlightResponse> save(@Valid @RequestBody FlightRequest request) throws Exception {
        FlightResponse response = flightService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
