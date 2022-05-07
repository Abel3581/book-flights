package com.staff.flight.mapper;

import com.staff.flight.entity.Airport;
import com.staff.flight.entity.model.request.AirportRequest;
import com.staff.flight.entity.model.response.AirportResponse;
import lombok.Builder;
import org.springframework.stereotype.Service;

@Builder
@Service
public class AirportMapper {


    public static Airport airportDTO2Entity(AirportRequest dto) {
        return Airport.builder()
                .name(dto.getName())
                .code(dto.getCode())
                .build();
    }

    public static AirportResponse airportEntity2DTO(Airport entity) {
        return AirportResponse.builder()
                .name(entity.getName())
                .code(entity.getCode())
                .build();
    }
}
