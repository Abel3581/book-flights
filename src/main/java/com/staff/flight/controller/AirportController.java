package com.staff.flight.controller;

import com.staff.flight.entity.model.request.AirportRequest;
import com.staff.flight.entity.model.response.AirportResponse;
import com.staff.flight.service.abstraction.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/airport")
public class AirportController {

    private final AirportService service;

   @PostMapping("")
    public ResponseEntity<AirportResponse> save(@Valid @RequestBody AirportRequest request){
        AirportResponse response = service.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
    @GetMapping("/{id}")
    public ResponseEntity<AirportResponse> getById(@PathVariable long id){
       AirportResponse response = service.getById(id);
       return ResponseEntity.ok().body(response);
    }
}
