package com.staff.flight.mapper;

import com.staff.flight.entity.Airport;
import com.staff.flight.entity.Flight;
import com.staff.flight.entity.model.request.AirportRequest;
import com.staff.flight.entity.model.response.AirportResponse;
import com.staff.flight.entity.model.response.FlightResponse;
import lombok.Builder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Builder
@Component
public class AirportMapper {

    private final FlightMapper flightMapper;

    // Con Builder
    public Airport airportDTO2Entity(AirportRequest dto) {
        return Airport.builder()
                .name(dto.getName())
                .code(dto.getCode())
                .build();
    }

    public AirportResponse airportEntity2DTO(Airport entity) {

        return AirportResponse.builder()
                .name(entity.getName())
                .code(entity.getCode())
                .build();
    }


    // Sin Builder
    public AirportResponse entity2DTO(Airport airport, boolean loadFlight){
        AirportResponse response = new AirportResponse();
        response.setName(airport.getName());
        response.setCode(airport.getCode());
        if(loadFlight){
            List<FlightResponse> flightResponses = flightMapper.flightEntitySet2DtoList(airport.getFlightLis());
            response.setFlightList(flightResponses);
        }
        return response;
    }
}
