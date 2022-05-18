package com.staff.flight.mapper;
import com.staff.flight.entity.Passenger;
import com.staff.flight.entity.model.request.PassengerRegisterRequest;
import com.staff.flight.entity.model.response.InfoUserResponse;
import com.staff.flight.entity.model.response.PassengerRegisterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class PassengerMapper {

    public Passenger requestDTO2Entity(PassengerRegisterRequest request) {
        Passenger passenger = new Passenger();
        passenger.setEmail(request.getEmail());
        passenger.setCountry(request.getCountry());
        passenger.setDni(request.getDni());
        passenger.setFirstName(request.getFirstName());
        passenger.setLastName(request.getLastName());

        passenger.setTimestamp(new Timestamp(System.currentTimeMillis()));
        passenger.setSoftDelete(false);

        return passenger;
    }

    public PassengerRegisterResponse entity2RegisterResponseDTO(Passenger passenger) {
        PassengerRegisterResponse response = new PassengerRegisterResponse();
        response.setId(passenger.getPassengerId());
        response.setDni(passenger.getDni());
        response.setCountry(passenger.getCountry());
        response.setEmail(passenger.getEmail());
        response.setFirstName(passenger.getFirstName());
        response.setLastName(passenger.getLastName());
        return response;
    }

    public InfoUserResponse passengerEntity2DTO(Passenger passenger, boolean loadBookings) {
        InfoUserResponse infoUser = new InfoUserResponse();
        infoUser.setCountry(passenger.getCountry());
        infoUser.setDni(passenger.getDni());
        infoUser.setFirstName(passenger.getFirstName());
        infoUser.setLastName(passenger.getLastName());
        infoUser.setEmail(passenger.getEmail());
        infoUser.setPassword(passenger.getPassword());
        infoUser.setId(passenger.getPassengerId());
        if(loadBookings){
            //TODO Falta terminar que devuelva las reservas.
            // It remains to finish that it returns the reservations.
        }
        return infoUser;
    }
}
