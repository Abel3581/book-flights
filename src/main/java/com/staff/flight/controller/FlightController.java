package com.staff.flight.controller;

import com.staff.flight.model.request.FlightRequest;
import com.staff.flight.model.response.FlightResponse;
import com.staff.flight.service.abstraction.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<FlightResponse> getFlightBy(@PathVariable Long id) {
        FlightResponse response = flightService.getFlightBy(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleted(@PathVariable Long id)throws EntityNotFoundException{
        flightService.deleted(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlightResponse> update(@PathVariable Long id, @RequestBody FlightRequest request){
        FlightResponse response = flightService.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<FlightResponse>> getAll(){
        List<FlightResponse> response = flightService.getAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/destination")
    public ResponseEntity<List<FlightResponse>> getFlightByName(@RequestParam String destination){
        List<FlightResponse> response = flightService.getFlightByName(destination);
        return ResponseEntity.ok().body(response);
    }





}
