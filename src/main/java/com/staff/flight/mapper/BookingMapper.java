package com.staff.flight.mapper;

import com.staff.flight.entity.Booking;
import com.staff.flight.entity.model.enums.EnumBooking;
import com.staff.flight.entity.model.request.BookingRequest;
import com.staff.flight.entity.model.response.BookingResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class BookingMapper {
    public Booking bookingDTO2Entity(BookingRequest request) {
        Booking entity = new Booking();
        entity.setConditions(EnumBooking.REALIZED);
        entity.setIssue(LocalDateTime.now());
        entity.setDepartureDate(request.getDepartureDate());
     /*   if(request.getDepartureDate().isAfter(request.getExpiration())||
        request.getDepartureDate().isEqual(request.getExpiration())){
            throw new RuntimeException("The departure date cannot be greater than the expiration date and they cannot be the same");
        }*/
        return entity;
    }

    public BookingResponse bookingEntity2DTO(Booking save) {
        BookingResponse response = new BookingResponse();
        response.setBookingId(save.getBookingId());
        response.setConditions(save.getConditions());
        response.setExpiration(save.getExpiration());
        response.setFlightId(save.getFlight().getFlightId());
        response.setIssue(save.getIssue());
        response.setPassengerId(save.getPassenger().getPassengerId());
        response.setDepartureDate(save.getDepartureDate());
        return response;
    }
}
