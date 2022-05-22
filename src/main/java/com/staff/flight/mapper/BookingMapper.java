package com.staff.flight.mapper;

import com.staff.flight.model.entity.Booking;
import com.staff.flight.model.enums.EnumBooking;
import com.staff.flight.model.request.BookingRequest;
import com.staff.flight.model.response.BookingResponse;
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
        entity.setPayment(request.getPayment());
        return entity;
    }

    public BookingResponse bookingEntity2DTO(Booking save) {
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
            responses.add(bookingEntity2DTO(b));
        }
        return responses;
    }

    public List<BookingResponse> bookingEntitySet2Dto(Booking booking) {
        List<BookingResponse> responses = new ArrayList<>();
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setBookingId(booking.getBookingId());
        bookingResponse.setConditions(booking.getConditions());
        bookingResponse.setExpiration(booking.getExpiration());
        bookingResponse.setDateOfIssue(booking.getDateOfIssue());
        bookingResponse.setFlightId(booking.getFlight().getFlightId());
        bookingResponse.setPassengerId(booking.getPassenger().getPassengerId());

        responses.add(bookingResponse);
        return responses;
    }
}
