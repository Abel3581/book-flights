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
    private LocalDate departureDate;

    private LocalDateTime hour;
    // DateTimeFormatter f = DateTimeFormatter.ofPattern("hh:MM");
    //System.out.println("Hora:mes = " + hora.format(f));
    @Enumerated(value = EnumType.STRING)
    private EnumFlight status;

    private Integer ability; //capacidad

    private Integer origin;

    private Integer destination;

    private BigDecimal price;

    private String currencyCode; //ARS, USD

    private Airport airport;
    //private List<Booking> bookings;
    //private List<Staff> staffList;


}
