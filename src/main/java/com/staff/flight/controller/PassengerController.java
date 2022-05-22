package com.staff.flight.controller;

import com.staff.flight.model.response.InfoUserResponse;
import com.staff.flight.service.abstraction.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/passenger")
public class PassengerController {

    private final PassengerService passengerService;

    @GetMapping("/{id}")
    private ResponseEntity<InfoUserResponse> getById(@PathVariable long id){
        InfoUserResponse response = passengerService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
