package com.staff.flight.service;

import com.staff.flight.entity.Airport;
import com.staff.flight.entity.model.request.AirportRequest;
import com.staff.flight.entity.model.response.AirportResponse;
import com.staff.flight.mapper.AirportMapper;
import com.staff.flight.repository.AirportRepository;
import com.staff.flight.service.abstraction.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;
    private final AirportMapper airportMapper;
    @Override
    public AirportResponse save(AirportRequest request){

            Airport airportEntity = AirportMapper.airportDTO2Entity(request);
            Airport saved = airportRepository.save(airportEntity);
            return AirportMapper.airportEntity2DTO(saved);


    }

}
