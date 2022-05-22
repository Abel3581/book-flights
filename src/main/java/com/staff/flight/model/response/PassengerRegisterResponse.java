package com.staff.flight.model.response;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PassengerRegisterResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email; // es el username
    private String password;
    private String dni;
    private String country;
    private String token;
}
