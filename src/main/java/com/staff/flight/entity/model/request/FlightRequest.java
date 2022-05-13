package com.staff.flight.entity.model.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.staff.flight.entity.model.enums.EnumFlight;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class FlightRequest {

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDateTime departureDate;

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
