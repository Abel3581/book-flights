package com.staff.flight.model.response;


import com.staff.flight.model.enums.EnumFlight;
import lombok.*;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;



@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FlightResponse {

    private Long flightId;

    @Enumerated(value = EnumType.STRING)
    private EnumFlight status;

    private Integer ability; //capacidad

    private String destination;

    private double price;

    private String currencyCode; //ARS, USD

    private AirportResponse airport;

    private long airportId;
    //private List<Booking> bookings;
    //private List<Staff> staffList;


}
