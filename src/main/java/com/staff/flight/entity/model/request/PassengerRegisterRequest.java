package com.staff.flight.entity.model.request;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Date;


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
