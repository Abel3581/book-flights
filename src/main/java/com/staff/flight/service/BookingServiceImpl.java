package com.staff.flight.service;

import com.staff.flight.entity.Booking;
import com.staff.flight.entity.Flight;
import com.staff.flight.entity.Passenger;
import com.staff.flight.entity.User;
import com.staff.flight.entity.model.request.BookingRequest;
import com.staff.flight.entity.model.response.BookingResponse;
import com.staff.flight.mapper.BookingMapper;
import com.staff.flight.repository.BookingRepository;
import com.staff.flight.repository.FlightRepository;
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

    private final FlightRepository flightRepository;

    @Override
    public BookingResponse save(BookingRequest request) {
        Booking entity = bookingMapper.bookingDTO2Entity(request);
        User user = passengerService.getInfoUser();
        entity.setPassenger((Passenger) user);
        Flight flight = flightService.getFlightById(request.getFlightId());
        entity.setFlight(flight);
        entity.setExpiration(request.getDepartureDate().plusHours(1));

        if (entity.getDepartureDate().isBefore(entity.getDateOfIssue())) {
            throw new RuntimeException("The departure date cannot be before the current day.");
        } else {
            Booking save = bookingRepository.save(entity);
            if(flight.getOccupiedSeats() >= flight.getAbility()){
                throw new RuntimeException("The maximum capacity is already full choose another flight.");
            }else {
                flight.addBooking(entity);
                flight.contOccupiedSeats();
                flightRepository.save(flight);
                ((Passenger) user).addBooking(entity);
                return bookingMapper.bookingEntity2DTO(save,false);
            }
        }
    }
}
