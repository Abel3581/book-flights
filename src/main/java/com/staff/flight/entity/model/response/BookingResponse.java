package com.staff.flight.entity.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    private long bookingId;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    private LocalDateTime issue;//fecha_emision

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    private LocalDateTime expiration;//fecha_vencimiento

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    private LocalDateTime departureDate;//fecha de salida

    @Enumerated(value = EnumType.STRING)
    private EnumBooking conditions;

    private long passengerId;

    //@JsonIgnore)
    private Passage passage;

    private long flightId;

}
