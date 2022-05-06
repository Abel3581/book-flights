package com.staff.flight.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @Column(name = "role_id")
    private List<Role> roles;

}
