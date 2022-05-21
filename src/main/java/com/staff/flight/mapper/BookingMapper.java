package com.staff.flight.mapper;

import com.staff.flight.entity.Booking;
import com.staff.flight.entity.model.enums.EnumBooking;
import com.staff.flight.entity.model.request.BookingRequest;
import com.staff.flight.entity.model.response.BookingResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class BookingMapper {
    public Booking bookingDTO2Entity(BookingRequest request) {
        Booking entity = new Booking();
        entity.setConditions(EnumBooking.REALIZED);
        entity.setDateOfIssue(LocalDateTime.now());
        entity.setDepartureDate(request.getDepartureDate());
        return entity;
    }

    public BookingResponse bookingEntity2DTO(Booking save, boolean loadBooking) {
        BookingResponse response = new BookingResponse();
        response.setBookingId(save.getBookingId());
        response.setConditions(save.getConditions());
        response.setExpiration(save.getExpiration());
        response.setFlightId(save.getFlight().getFlightId());
        response.setDateOfIssue(save.getDateOfIssue());
        response.setPassengerId(save.getPassenger().getPassengerId());
        response.setDepartureDate(save.getDepartureDate());
        return response;
    }

    public List<BookingResponse> bookingEntitySet2DtoList(Collection<Booking> bookings) {
        List<BookingResponse> responses = new ArrayList<>();
        for (Booking b: bookings){
            responses.add(bookingEntity2DTO(b,true));
        }
        return responses;
    }
}
