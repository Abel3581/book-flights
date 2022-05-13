package com.staff.flight.entity.model.response;

import com.staff.flight.entity.Airport;
import com.staff.flight.entity.Booking;
import com.staff.flight.entity.Staff;
import com.staff.flight.entity.model.enums.EnumFlight;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FlightResponse {

    private Long flightId;

    private LocalDateTime departureDate;

    @Enumerated(value = EnumType.STRING)
    private EnumFlight status;

    private Integer ability; //capacidad

    private String origin;

    private String destination;

    private double price;

    private String currencyCode; //ARS, USD

    private Airport airport;
    private long airportId;
    //private List<Booking> bookings;
    //private List<Staff> staffList;


}
