package com.staff.flight.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "airport")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airport_id")
    private Long airportId;

    @NotEmpty(message = "The name is required and cannot be null or empty")
    private String name;

    @NotEmpty(message = "The code is mandatory and cannot be null or empty")
    @Column(name = "iata_code")
    private String code;

    @OneToMany(mappedBy = "airport",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Flight> flightLis = new ArrayList<>();
}
