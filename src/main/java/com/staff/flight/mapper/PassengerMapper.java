package com.staff.flight.mapper;

import com.staff.flight.config.JwtUtil;
import com.staff.flight.entity.Passenger;
import com.staff.flight.entity.Role;
import com.staff.flight.entity.model.enums.ApplicationRole;
import com.staff.flight.entity.model.request.PassengerRegisterRequest;
import com.staff.flight.entity.model.response.PassengerRegisterResponse;
import com.staff.flight.repository.PassengerRepository;
import com.staff.flight.service.abstraction.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Component
public class PassengerMapper {


    private final PasswordEncoder passwordEncoder;

    public Passenger requestDTO2Entity(PassengerRegisterRequest request) {
        Passenger passenger = new Passenger();
        passenger.setEmail(request.getEmail());
        passenger.setCountry(request.getCountry());
        passenger.setDni(request.getDni());
        passenger.setFirstName(request.getFirstName());
        passenger.setLastName(request.getLastName());
        passenger.setPassword(passwordEncoder.encode(request.getPassword()));
        passenger.setTimestamp(new Timestamp(System.currentTimeMillis()));
        passenger.setSoftDelete(false);

        return passenger;
    }

    public PassengerRegisterResponse entity2RegisterResponseDTO(Passenger passenger) {
        PassengerRegisterResponse response = new PassengerRegisterResponse();
        response.setId(passenger.getPassengerId());
        response.setDni(passenger.getDni());
        response.setCountry(passenger.getCountry());
        response.setEmail(passenger.getEmail());
        response.setFirstName(passenger.getFirstName());
        response.setLastName(passenger.getLastName());
        return response;
    }
}
