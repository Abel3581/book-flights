package com.staff.flight.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.staff.flight.entity.model.enums.EnumFlight;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private Long flightId;

    //@JsonFormat(pattern="dd/MM/yyyy")
    private LocalDateTime departureDate;

    @Enumerated(value = EnumType.STRING)
    private EnumFlight status;

    private Integer ability; //capacidad

    private String destination;

    private Double price;

    @Column(name = "currency_code")
    private String currencyCode; //ARS, USD

    private int occupiedSeats; //Asientos ocupados



    @Column(nullable = true)
    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Booking> bookings = new ArrayList<>();

    @Column(nullable = true)
    //@JsonIgnoreProperties(value = "flight")
    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Staff> staffList = new ArrayList<>();

    @JsonIgnore
    @JoinColumn(name = "airport_id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Airport airport;


    public void addBooking(Booking booking){
        bookings.add(booking);
    }
}
