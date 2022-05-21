package com.staff.flight.entity.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PassengerResponse {

    private String firstName;
    private String lastName;
    private List<BookingResponse> bookings;
}
