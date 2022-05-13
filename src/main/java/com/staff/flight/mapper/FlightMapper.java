package com.staff.flight.mapper;

import com.staff.flight.entity.Airport;
import com.staff.flight.entity.Flight;
import com.staff.flight.entity.model.enums.EnumFlight;
import com.staff.flight.entity.model.request.FlightRequest;
import com.staff.flight.entity.model.response.FlightResponse;
import com.staff.flight.service.abstraction.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Component
public class FlightMapper {



    public List<FlightResponse> flightEntitySet2DtoList(List<Flight> flightLis) {
        return null;

    }

    public Flight flightDTO2Entity(FlightRequest request) {
        Flight entity = new Flight();
        entity.setAbility(request.getAbility());
        entity.setCurrencyCode(request.getCurrencyCode());
        entity.setDestination(request.getDestination());
        entity.setPrice(request.getPrice());
        entity.setStatus(EnumFlight.INPROCESS);
        entity.setDepartureDate(LocalDateTime.now());

        return entity;
    }

    public FlightResponse flightEntity2DTO(Flight flight) {
        FlightResponse response = new FlightResponse();
        response.setAbility(flight.getAbility());
        response.setFlightId(flight.getFlightId());
        response.setDestination(flight.getDestination());
        response.setCurrencyCode(flight.getCurrencyCode());
        response.setStatus(flight.getStatus());
        response.setPrice(flight.getPrice());
        response.setAirportId(flight.getAirport().getAirportId());
        response.setDepartureDate(flight.getDepartureDate());
        return response;
    }
}
