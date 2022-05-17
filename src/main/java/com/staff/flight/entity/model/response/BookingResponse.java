package com.staff.flight.entity.model.response;

import com.staff.flight.entity.Flight;
import com.staff.flight.entity.Passage;
import com.staff.flight.entity.Passenger;
import com.staff.flight.entity.model.enums.EnumBooking;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingResponse {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime issue;//fecha_emision

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime expiration;//fecha_vencimiento

    @Enumerated(value = EnumType.STRING)
    private EnumBooking conditions;

    private Passenger passenger;

    //@JsonIgnore)
    private Passage passage;

    private Flight flight;

}
