package com.staff.flight.entity.model.response;

import com.staff.flight.entity.Booking;
import com.staff.flight.entity.Staff;
import com.staff.flight.entity.model.enums.EnumFlight;
import lombok.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FlightResponse {

    private Long flightId;

    private Date date;
    private EnumFlight status;
    private Integer ability; //capacidad
    private Integer origin;
    private Integer destination;
    private BigDecimal price;
    private String currencyCode; //ARS, USD

    private List<Booking> bookings;
    private List<Staff> staffList;


}
