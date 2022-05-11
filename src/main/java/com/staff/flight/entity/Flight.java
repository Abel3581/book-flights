package com.staff.flight.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate departureDate;

    private LocalDateTime hour;

    @Enumerated(value = EnumType.STRING)
    private EnumFlight status;

    private Integer ability; //capacidad

    @Column(name = "airport_origin")
    private Integer origin;

    @Column(name = "airport_destination")
    private Integer destination;

    private BigDecimal price;

    @Column(name = "currency_code")
    private String currencyCode; //ARS, USD

    @Column(nullable = true)
    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Booking> bookings = new ArrayList<>();

    @Column(nullable = true)
    //@JsonIgnoreProperties(value = "flight")
    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Staff> staffList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "airport_id")
    private Airport airport;

    public void addBooking(Booking booking){
        bookings.add(booking);
    }
}
