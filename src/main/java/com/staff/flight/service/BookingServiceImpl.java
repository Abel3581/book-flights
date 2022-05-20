package com.staff.flight.service;

import com.staff.flight.entity.Booking;
import com.staff.flight.entity.Flight;
import com.staff.flight.entity.Passenger;
import com.staff.flight.entity.User;
import com.staff.flight.entity.model.request.BookingRequest;
import com.staff.flight.entity.model.response.BookingResponse;
import com.staff.flight.mapper.BookingMapper;
import com.staff.flight.repository.BookingRepository;
import com.staff.flight.service.abstraction.BookingService;
import com.staff.flight.service.abstraction.FlightService;
import com.staff.flight.service.abstraction.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final PassengerService passengerService;
    private final FlightService flightService;

    @Override
    public BookingResponse save(BookingRequest request) {
        Booking entity = bookingMapper.bookingDTO2Entity(request);
        User user = passengerService.getInfoUser();
        entity.setPassenger((Passenger) user);
        Flight flight = flightService.getFlightById(request.getFlightId());
        entity.setFlight(flight);
        entity.setExpiration(request.getDepartureDate().plusHours(1));

        if (entity.getDepartureDate().isBefore(entity.getIssue())) {
            throw new RuntimeException("La fecha de salida no puede ser antes del dia actual");
        } else {
            Booking save = bookingRepository.save(entity);
            flight.addBooking(entity);
            return bookingMapper.bookingEntity2DTO(save);
        }
    }
}
