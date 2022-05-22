package com.staff.flight.model.response;

import com.staff.flight.model.entity.Booking;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PassageResponse {

    private Long id;

    private Long idPassenger;

    private LocalDateTime issue;//emision

    private boolean paymentInfo;//info pago

    private BookingResponse booking;
}
