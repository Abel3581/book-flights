package com.staff.flight.service;


import com.staff.flight.entity.Airport;
import com.staff.flight.entity.Flight;
import com.staff.flight.entity.model.request.FlightRequest;
import com.staff.flight.entity.model.response.FlightResponse;
import com.staff.flight.mapper.AirportMapper;
import com.staff.flight.mapper.FlightMapper;
import com.staff.flight.repository.FlightRepository;
import com.staff.flight.service.abstraction.AirportService;
import com.staff.flight.service.abstraction.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FlightServiceImpl implements FlightService {

    private final AirportMapper airportMapper;

    private final AirportService airportService;
    private final FlightMapper flightMapper;
    private final FlightRepository flightRepository;

    //TODO-> este save guarda un vuelo y devuelve ese vuelo con el id del aeropuerto y guarda en el aeropuerto el vuelo
    //TODO-> this save saves a flight and returns that flight with the airport id and saves the flight in the airport
    @Override
    public FlightResponse save(FlightRequest request) {
        Flight entity = flightMapper.flightDTO2Entity(request);
        Airport airport = airportService.getAirportBy(request.getAirportId());
        entity.setAirport(airport);
        Flight flightSave = flightRepository.save(entity);
        airport.addFlights(flightSave);//I save the flight at the airport
        return flightMapper.flightEntity2DTO(flightSave);
    }
    @Override
    public FlightResponse getFlightBy(Long id) {
       Flight flight = flightRepository.findById(id).orElseThrow();
       FlightResponse response = flightMapper.flightEntity2DTO(flight);
       response.setAirport(airportService.getAirport(flight.getAirport().getAirportId()));
       return response;
    }
}
