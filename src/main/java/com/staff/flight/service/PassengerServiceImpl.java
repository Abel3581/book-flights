package com.staff.flight.service;


import com.staff.flight.config.JwtUtil;
import com.staff.flight.entity.Passenger;
import com.staff.flight.entity.Role;
import com.staff.flight.entity.model.enums.ApplicationRole;
import com.staff.flight.entity.model.request.PassengerAuthenticationRequest;
import com.staff.flight.entity.model.request.PassengerRegisterRequest;
import com.staff.flight.entity.model.response.PassengerAuthenticatedResponse;
import com.staff.flight.entity.model.response.PassengerRegisterResponse;
import com.staff.flight.mapper.PassengerMapper;
import com.staff.flight.repository.PassengerRepository;
import com.staff.flight.service.abstraction.PassengerService;
import com.staff.flight.service.abstraction.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PassengerServiceImpl  implements PassengerService, UserDetailsService {

    private static final String USER_NOT_FOUND_MESSAGE = "User not found.";
    private final PassengerRepository passengerRepository;
    private final PassengerMapper passengerMapper;
    private final RoleService roleService;
    private final JwtUtil jwt;

    private final AuthenticationManager authenticationManager;


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
    //Login
    @Override
    public PassengerAuthenticatedResponse authentication(PassengerAuthenticationRequest request){
        Passenger passenger = getPassenger(request.getEmail());
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        return new PassengerAuthenticatedResponse(jwt.generateToken(passenger), passenger.getEmail(), passenger.getAuthorities());

    }

    private Passenger getPassenger(String email) {
        Passenger passenger = passengerRepository.findByEmail(email);
        if(passenger == null){
            throw new UsernameNotFoundException(USER_NOT_FOUND_MESSAGE);
        }
        return passenger;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getPassenger(username);
    }
}
