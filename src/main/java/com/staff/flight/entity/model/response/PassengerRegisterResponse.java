package com.staff.flight.entity.model.response;

import lombok.*;

import java.sql.Timestamp;
import java.util.Date;
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