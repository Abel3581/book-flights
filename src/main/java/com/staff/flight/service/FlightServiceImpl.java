package com.staff.flight.service;

import com.staff.flight.entity.Airport;
import com.staff.flight.entity.Flight;
import com.staff.flight.entity.model.request.FlightRequest;
import com.staff.flight.entity.model.response.AirportResponse;
import com.staff.flight.entity.model.response.FlightResponse;
import com.staff.flight.mapper.AirportMapper;
import com.staff.flight.mapper.FlightMapper;
import com.staff.flight.repository.FlightRepository;
import com.staff.flight.service.abstraction.AirportService;
import com.staff.flight.service.abstraction.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FlightServiceImpl implements FlightService {

    private final AirportMapper airportMapper;

    private final AirportService airportService;
    private final FlightMapper flightMapper;
    private final FlightRepository flightRepository;

    //TODO-> este save guarda un vuelo y devuelve ese vuelo con su aeropuerto mas los vuelos de ese aeropuerto
    //TODO-> this save saves a flight and returns that flight with its airport plus the flights from that airport
    @Override
    public FlightResponse save(FlightRequest request) {
        Flight entity = flightMapper.flightDTO2Entity(request);
        entity.setAirport(airportService.getAirport(request.getAirportId()));
        Flight flightSave = flightRepository.save(entity);
        FlightResponse response = flightMapper.flightEntity2DTO(flightSave);
        return response;
    }
}
