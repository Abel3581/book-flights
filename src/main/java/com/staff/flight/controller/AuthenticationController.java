package com.staff.flight.controller;

import com.staff.flight.entity.model.request.PassengerAuthenticationRequest;
import com.staff.flight.entity.model.request.PassengerRegisterRequest;
import com.staff.flight.entity.model.response.PassengerAuthenticatedResponse;
import com.staff.flight.entity.model.response.PassengerRegisterResponse;
import com.staff.flight.service.abstraction.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final PassengerService passengerService;

    @PostMapping("/register")
    public ResponseEntity<PassengerRegisterResponse> register(@Valid @RequestBody PassengerRegisterRequest request){
        PassengerRegisterResponse response = passengerService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<PassengerAuthenticatedResponse> login(@Valid @RequestBody PassengerAuthenticationRequest request){
        PassengerAuthenticatedResponse response = passengerService.authentication(request);
        return ResponseEntity.ok().body(response);
    }


}
