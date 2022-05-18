package com.staff.flight.controller;

import com.staff.flight.entity.User;
import com.staff.flight.entity.model.request.PassengerAuthenticationRequest;
import com.staff.flight.entity.model.request.PassengerRegisterRequest;
import com.staff.flight.entity.model.response.InfoUserResponse;
import com.staff.flight.entity.model.response.PassengerAuthenticatedResponse;
import com.staff.flight.entity.model.response.PassengerRegisterResponse;
import com.staff.flight.exception.EmailAlreadyExistException;
import com.staff.flight.exception.NotFoundExceptions;
import com.staff.flight.service.abstraction.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final PassengerService passengerService;

    @PostMapping("/register")
    public ResponseEntity<PassengerRegisterResponse> register(@Valid @RequestBody PassengerRegisterRequest request)throws
            EmailAlreadyExistException {
        PassengerRegisterResponse response = passengerService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<PassengerAuthenticatedResponse> login(@Valid @RequestBody PassengerAuthenticationRequest request){
        PassengerAuthenticatedResponse response = passengerService.authentication(request);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/me")
    public ResponseEntity<InfoUserResponse> infoUserLogged()throws NotFoundExceptions {
        return new ResponseEntity<>(passengerService.infoUserLogged(), HttpStatus.OK);
    }

    @GetMapping("/mee")
    public ResponseEntity<User> userLogged() throws NotFoundExceptions {
        return new ResponseEntity<>(passengerService.getInfoUser(), HttpStatus.OK);
    }


}
