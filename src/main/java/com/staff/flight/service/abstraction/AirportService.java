package com.staff.flight.service.abstraction;

import com.staff.flight.entity.Airport;
import com.staff.flight.entity.model.request.AirportRequest;
import com.staff.flight.entity.model.response.AirportResponse;

public interface AirportService {
    AirportResponse save(AirportRequest request);
    AirportResponse getById(long id);

    Airport getAirport(long id);
}
