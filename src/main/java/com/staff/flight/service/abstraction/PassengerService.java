package com.staff.flight.service.abstraction;

import com.staff.flight.entity.Passenger;
import com.staff.flight.entity.User;
import com.staff.flight.entity.model.request.PassengerAuthenticationRequest;
import com.staff.flight.entity.model.request.PassengerRegisterRequest;
import com.staff.flight.entity.model.response.InfoUserResponse;
import com.staff.flight.entity.model.response.PassengerAuthenticatedResponse;
import com.staff.flight.entity.model.response.PassengerRegisterResponse;
import com.staff.flight.exception.EmailAlreadyExistException;
import com.staff.flight.exception.NotFoundExceptions;

public interface PassengerService {
    PassengerRegisterResponse register(PassengerRegisterRequest request)throws EmailAlreadyExistException;

    PassengerAuthenticatedResponse authentication(PassengerAuthenticationRequest request);

    InfoUserResponse infoUserLogged() throws NotFoundExceptions;

    public Passenger findByEmail(String email);

    public User getInfoUser()throws NotFoundExceptions;
}
