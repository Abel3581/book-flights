package com.staff.flight.service.abstraction;

import com.staff.flight.model.entity.Passenger;
import com.staff.flight.model.entity.User;
import com.staff.flight.model.request.PassengerAuthenticationRequest;
import com.staff.flight.model.request.PassengerRegisterRequest;
import com.staff.flight.model.response.InfoUserResponse;
import com.staff.flight.model.response.PassengerAuthenticatedResponse;
import com.staff.flight.model.response.PassengerRegisterResponse;
import com.staff.flight.exception.EmailAlreadyExistException;
import com.staff.flight.exception.NotFoundExceptions;

public interface PassengerService {
    PassengerRegisterResponse register(PassengerRegisterRequest request)throws EmailAlreadyExistException;

    PassengerAuthenticatedResponse authentication(PassengerAuthenticationRequest request);

    InfoUserResponse infoUserLogged() throws NotFoundExceptions;

    public Passenger findByEmail(String email);


    public User getInfoUser()throws NotFoundExceptions;

    InfoUserResponse getById(long id);
}
