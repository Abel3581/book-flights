package com.staff.flight.service;

import com.staff.flight.entity.Airport;
import com.staff.flight.entity.model.request.AirportRequest;
import com.staff.flight.entity.model.response.AirportResponse;
import com.staff.flight.mapper.AirportMapper;
import com.staff.flight.repository.AirportRepository;
import com.staff.flight.service.abstraction.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;
    private final AirportMapper airportMapper;
    @Override
    public AirportResponse save(AirportRequest request){

            Airport airportEntity = airportMapper.airportDTO2Entity(request);
            Airport saved = airportRepository.save(airportEntity);
            return airportMapper.airportEntity2DTO(saved);
    }
    @Override
    public AirportResponse getById(long id) {
        Airport airport = airportRepository.findById(id).orElseThrow();
        return airportMapper.entity2DTO(airport, false);
    }

    @Override
    public AirportResponse getAirport(long id) {
       Optional<Airport> airport = airportRepository.findById(id);
       if(airport.isEmpty() || airport.get().isSoftDelete()){
           throw new EntityNotFoundException("Airport not found");
       }
       AirportResponse response = new AirportResponse();
       response.setId(airport.get().getAirportId());
       response.setName(airport.get().getName());
       response.setCode(airport.get().getCode());

       return response;
    }

    @Override
    public Airport getAirportBy(long airportId) {
        Optional<Airport> airport = airportRepository.findById(airportId);
        if(airport.isEmpty() || airport.get().isSoftDelete()){
            throw new EntityNotFoundException("Airport not found");
        }
        return airport.get();
    }

    @Override
    public void deleted(Long id) throws EntityNotFoundException {
        Airport airport = getAirportBy(id);
        airport.setSoftDelete(true);
        airportRepository.save(airport);
    }

}
