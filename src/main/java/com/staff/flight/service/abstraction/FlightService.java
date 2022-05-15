package com.staff.flight.service.abstraction;

import com.staff.flight.entity.Flight;
import com.staff.flight.entity.model.request.FlightRequest;
import com.staff.flight.entity.model.response.FlightResponse;

import javax.persistence.EntityNotFoundException;

public interface FlightService {
    FlightResponse save(FlightRequest request) throws Exception;

    FlightResponse getFlightBy(Long id);

    void deleted(Long id)throws EntityNotFoundException;

    Flight getFlightById(Long id);
}
