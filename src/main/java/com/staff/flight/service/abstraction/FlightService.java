package com.staff.flight.service.abstraction;

import com.staff.flight.entity.model.request.FlightRequest;
import com.staff.flight.entity.model.response.FlightResponse;

public interface FlightService {
    FlightResponse save(FlightRequest request) throws Exception;

    FlightResponse getFlightBy(Long id);
}
