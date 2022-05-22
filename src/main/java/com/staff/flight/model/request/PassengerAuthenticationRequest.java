package com.staff.flight.model.request;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PassengerAuthenticationRequest {

    private String email;
    private String password;
}
