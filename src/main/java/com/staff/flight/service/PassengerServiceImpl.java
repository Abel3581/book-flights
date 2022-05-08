package com.staff.flight.service;


import com.staff.flight.config.JwtUtil;
import com.staff.flight.entity.Passenger;
import com.staff.flight.entity.Role;
import com.staff.flight.entity.model.enums.ApplicationRole;
import com.staff.flight.entity.model.request.PassengerRegisterRequest;
import com.staff.flight.entity.model.response.PassengerRegisterResponse;
import com.staff.flight.mapper.PassengerMapper;
import com.staff.flight.repository.PassengerRepository;
import com.staff.flight.service.abstraction.PassengerService;
import com.staff.flight.service.abstraction.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PassengerServiceImpl  implements PassengerService {

    private final PassengerRepository passengerRepository;
    private final PassengerMapper passengerMapper;
    private final RoleService roleService;
    private final JwtUtil jwt;


    @Override
    public PassengerRegisterResponse register(PassengerRegisterRequest request){
        if(passengerRepository.findByEmail(request.getEmail()) != null){
           throw new RuntimeException("Email address is already used.");
        }
        Passenger passenger = passengerMapper.requestDTO2Entity(request);
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.findBy(ApplicationRole.USER.getFullRoleName()));
        passenger.setRoles(roles);
        Passenger passengerCreate = passengerRepository.save(passenger);
        PassengerRegisterResponse response = passengerMapper.entity2RegisterResponseDTO(passengerCreate);
        response.setToken(jwt.generateToken(passengerCreate));
        return response;
    }
}
