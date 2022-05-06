package com.staff.flight.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;
@Getter
@Setter
@MappedSuperclass
public class User {

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email; // es el username
    @Column(nullable = false)
    private String password;
    @Column(name = "registration_Date")
    private Date registrationDate;
    @Column(unique = true)
    private String dni;
    private String country;

}
