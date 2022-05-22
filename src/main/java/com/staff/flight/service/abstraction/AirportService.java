package com.staff.flight.service.abstraction;

import com.staff.flight.model.entity.Airport;
import com.staff.flight.model.request.AirportRequest;
import com.staff.flight.model.response.AirportResponse;

import javax.persistence.EntityNotFoundException;

public interface AirportService {
    AirportResponse save(AirportRequest request);
    AirportResponse getById(long id);

    AirportResponse getAirport(long id);

    Airport getAirportBy(long airportId);

    void deleted(Long id)throws EntityNotFoundException;

    AirportResponse update(Long id, AirportRequest request);
}
