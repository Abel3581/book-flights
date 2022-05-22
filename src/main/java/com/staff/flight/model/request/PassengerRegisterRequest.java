package com.staff.flight.model.request;


import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PassengerRegisterRequest {

    private String firstName;
    private String lastName;
    private String email; // es el username
    private String password;
    private String dni;
    private String country;

}
