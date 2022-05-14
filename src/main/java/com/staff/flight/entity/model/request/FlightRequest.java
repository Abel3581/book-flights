package com.staff.flight.entity.model.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.staff.flight.entity.model.enums.EnumFlight;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class FlightRequest {

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE,pattern = "yyyy-MM-dd")
    private Date departureDate;

    // DateTimeFormatter f = DateTimeFormatter.ofPattern("hh:MM");
    //System.out.println("Hora:mes = " + hora.format(f));

    @Enumerated(value = EnumType.STRING)
    private EnumFlight status;

    private Integer ability; //capacidad

    private String destination;

    private double price;

    private String currencyCode; //ARS, USD

    private long airportId;

}
