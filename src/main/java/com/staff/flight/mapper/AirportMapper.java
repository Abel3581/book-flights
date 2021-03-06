package com.staff.flight.mapper;

import com.staff.flight.model.entity.Airport;
import com.staff.flight.model.request.AirportRequest;
import com.staff.flight.model.response.AirportResponse;
import com.staff.flight.model.response.FlightResponse;
import lombok.Builder;
import org.springframework.stereotype.Component;

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
                .id(entity.getAirportId())
                .build();
    }


    // Sin Builder
    public AirportResponse entity2DTO(Airport airport, boolean loadFlight){
        AirportResponse response = new AirportResponse();
        response.setName(airport.getName());
        response.setCode(airport.getCode());
        response.setId(airport.getAirportId());

        if(loadFlight){
            List<FlightResponse> flightResponses = flightMapper.flightEntitySet2DtoList(airport.getFlights());
            response.setFlightList(flightResponses);
        }
        return response;
    }

    public Airport airportDTO2EntityResponse(AirportResponse response) {
        Airport airport = new Airport();
        airport.setAirportId(response.getId());
        airport.setName(response.getName());
        airport.setCode(response.getCode());
        return airport;
    }

    public void airportRefreshValues(Airport airport, AirportRequest request) {
        airport.setName(request.getName());
        airport.setCode(request.getCode());
    }
}
