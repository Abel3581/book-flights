package com.staff.flight.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InfoUserResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email; // es el username
    private String password;
    private String dni;
    private String country;
    private List<BookingResponse> bookings;
}
