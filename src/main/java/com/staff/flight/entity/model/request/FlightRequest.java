package com.staff.flight.entity.model.request;

import com.staff.flight.entity.model.enums.EnumFlight;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class FlightRequest {

    @Enumerated(value = EnumType.STRING)
    private EnumFlight status;

    private Integer ability; //capacidad

    private String destination;

    private double price;

    private String currencyCode; //ARS, USD

    private long airportId;

}
