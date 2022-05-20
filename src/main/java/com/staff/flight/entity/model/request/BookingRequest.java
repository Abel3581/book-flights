package com.staff.flight.entity.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.staff.flight.entity.Passage;
import com.staff.flight.entity.Passenger;
import com.staff.flight.entity.model.enums.EnumBooking;
import io.swagger.annotations.ApiImplicitParam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingRequest {

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    private LocalDateTime departureDate;//fecha de salida

    private Long flightId;

}
