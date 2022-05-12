package com.staff.flight.service.abstraction;

import com.staff.flight.entity.model.request.PassengerAuthenticationRequest;
import com.staff.flight.entity.model.request.PassengerRegisterRequest;
import com.staff.flight.entity.model.response.PassengerAuthenticatedResponse;
import com.staff.flight.entity.model.response.PassengerRegisterResponse;
import com.staff.flight.exception.EmailAlreadyExistException;

public interface PassengerService {
    PassengerRegisterResponse register(PassengerRegisterRequest request)throws EmailAlreadyExistException;

    PassengerAuthenticatedResponse authentication(PassengerAuthenticationRequest request);
}
