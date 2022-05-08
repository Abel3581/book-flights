package com.staff.flight.service.abstraction;

import com.staff.flight.entity.model.request.PassengerRegisterRequest;
import com.staff.flight.entity.model.response.PassengerRegisterResponse;

public interface PassengerService {
    PassengerRegisterResponse register(PassengerRegisterRequest request);
}
