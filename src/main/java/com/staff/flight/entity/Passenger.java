package com.staff.flight.entity;

import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "passenger")
public class Passenger extends User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passenger_id")
    private Long passengerId;

    @OneToMany(mappedBy = "passenger", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Booking> bookings = new ArrayList<>();


    public Passenger(String firstName, String lastName, String email, String password, Timestamp timestamp, String dni, String country, boolean softDelete, List<Role> roles, Long passengerId, List<Booking> bookings) {
        super(firstName, lastName, email, password, timestamp, dni, country, softDelete, roles);
        this.passengerId = passengerId;
        this.bookings = bookings;
    }

}
