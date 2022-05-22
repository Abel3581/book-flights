package com.staff.flight.service;


import com.staff.flight.config.JwtUtil;
import com.staff.flight.model.entity.Passenger;
import com.staff.flight.model.entity.Role;
import com.staff.flight.model.entity.User;
import com.staff.flight.model.enums.ApplicationRole;
import com.staff.flight.model.request.PassengerAuthenticationRequest;
import com.staff.flight.model.request.PassengerRegisterRequest;
import com.staff.flight.model.response.InfoUserResponse;
import com.staff.flight.model.response.PassengerAuthenticatedResponse;
import com.staff.flight.model.response.PassengerRegisterResponse;
import com.staff.flight.exception.EmailAlreadyExistException;
import com.staff.flight.exception.NotFoundExceptions;
import com.staff.flight.mapper.PassengerMapper;
import com.staff.flight.repository.PassengerRepository;
import com.staff.flight.service.abstraction.PassengerService;
import com.staff.flight.service.abstraction.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class PassengerServiceImpl  implements PassengerService, UserDetailsService {

    private static final String USER_NOT_FOUND_MESSAGE = "User not found.";
    private final PassengerRepository passengerRepository;
    private final PassengerMapper passengerMapper;
    private final RoleService roleService;
    private final JwtUtil jwt;

    private final PasswordEncoder passwordEncoder;


    private final AuthenticationManager authenticationManager;

    @Transactional
    @Override
    public PassengerRegisterResponse register(PassengerRegisterRequest request)throws EmailAlreadyExistException {
        if(passengerRepository.findByEmail(request.getEmail()) != null){
           throw new EmailAlreadyExistException();
        }
        Passenger passenger = passengerMapper.requestDTO2Entity(request);
        passenger.setPassword(passwordEncoder.encode(request.getPassword()));
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
        return new PassengerAuthenticatedResponse(jwt.generateToken(passenger), passenger.getEmail(),passenger.getAuthorities());

    }

    @Override
    public InfoUserResponse infoUserLogged() throws NotFoundExceptions {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Passenger passengerLogged = passengerRepository.findByEmail(principal.toString());
        return passengerMapper.passengerEntity2DTO(passengerLogged, false);
    }

    private Passenger getPassenger(String email) {
        Passenger passenger = passengerRepository.findByEmail(email);
        if(passenger == null){
            throw new UsernameNotFoundException(USER_NOT_FOUND_MESSAGE);
        }
        return passenger;

    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getPassenger(username);
    }

    @Override
    @Transactional
    public Passenger findByEmail(String email) {

        return passengerRepository.findByEmail(email);

    }

    @Override
    public User getInfoUser() throws NotFoundExceptions {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof User) {
            String username = ((User)principal).getUsername();
        } else {
            String username = principal.toString();
        }

        return passengerRepository.findByEmail(principal.toString());
    }

    //Devuelve el pasagero con sus reservas de vuelos
    //Return the passenger with their flight reservations
    @Override
    public InfoUserResponse getById(long id) {
        Passenger passenger = passengerRepository.findById(id).orElseThrow();
        return passengerMapper.passengerEntity2DTO(passenger,true);
    }

}
