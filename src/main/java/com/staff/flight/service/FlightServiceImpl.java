package com.staff.flight.service;


import com.staff.flight.model.entity.Airport;
import com.staff.flight.model.entity.Flight;
import com.staff.flight.model.request.FlightRequest;
import com.staff.flight.model.response.FlightResponse;
import com.staff.flight.mapper.FlightMapper;
import com.staff.flight.repository.FlightRepository;
import com.staff.flight.service.abstraction.AirportService;
import com.staff.flight.service.abstraction.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FlightServiceImpl implements FlightService {

   // private final AirportMapper airportMapper;
    private final AirportService airportService;
    private final FlightMapper flightMapper;
    private final FlightRepository flightRepository;

    //TODO-> este save guarda un vuelo y devuelve ese vuelo con el id del aeropuerto y guarda en el aeropuerto el vuelo
    //TODO-> this save saves a flight and returns that flight with the airport id and saves the flight in the airport
    @Override
    public FlightResponse save(FlightRequest request) {
        Flight entity = flightMapper.flightDTO2Entity(request);
        Airport airport = airportService.getAirportBy(request.getAirportId());
        if(entity.getDestination().equalsIgnoreCase(airport.getName())){
            throw new RuntimeException("The destination cannot be the same as the airport name.");
        }
        entity.setAirport(airport);
        Flight flightSave = flightRepository.save(entity);
        airport.addFlights(flightSave);//I save the flight at the airport
        return flightMapper.flightEntity2DTO(flightSave,false);

    }
    @Override
    public FlightResponse getFlightBy(Long id) {
       Flight flight = flightRepository.findById(id).orElseThrow();
       FlightResponse response = flightMapper.flightEntity2DTO(flight, true);
       response.setAirport(airportService.getAirport(flight.getAirport().getAirportId()));
       return response;
    }

    @Override
    public void deleted(Long id)throws EntityNotFoundException{
        Flight flight = getFlightById(id);
        flight.setSoftDelete(true);
        flightRepository.save(flight);
    }

    public Flight getFlightById(Long id) {
        Optional<Flight> flight = flightRepository.findById(id);
        if(flight.isEmpty() || flight.get().isSoftDelete()){
            throw new EntityNotFoundException("Flight not found");
        }
        return flight.get();
    }

    @Override // Actualiza el vuelo y su aeropuerto -> Update the flight and its airport
    public FlightResponse update(Long id, FlightRequest request) {
        Optional<Flight> flight = flightRepository.findById(id);
        if(flight.isEmpty()){
            throw new RuntimeException("Flight not found");
        }
        flightMapper.flightRefreshValues(flight.get(), request);
        flight.get().setAirport(airportService.getAirportBy(request.getAirportId()));
        Flight flightSaved = flightRepository.save(flight.get());
        return flightMapper.flightEntity2DTORefresh(flightSaved);
    }

    @Override
    public List<FlightResponse> getAll() {
        List<Flight> flights = flightRepository.findAll();
        return flightMapper.flightEntitySet2DtoList(flights);
    }

    @Override
    public List<FlightResponse> getFlightByName(String destination) {
        List<Flight> flights = flightRepository.findByDestination(destination);
        return flightMapper.flightEntitySet2DtoList(flights);
    }
}
