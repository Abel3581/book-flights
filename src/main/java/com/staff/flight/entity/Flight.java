package com.staff.flight.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.staff.flight.entity.model.enums.EnumFlight;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SQLDelete(sql = "UPDATE flight SET soft_delete=true flight_id=?")
@Where(clause = "soft_delete=false")
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

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    private LocalDateTime departureDate;

    @Enumerated(value = EnumType.STRING)
    private EnumFlight status;

    private Integer ability; //capacidad

    private String destination;

    private Double price;

    @Column(name = "currency_code")
    private String currencyCode; //ARS, USD

    private int occupiedSeats; //Asientos ocupados

    @Column(name = "soft_delete")
    private boolean softDelete = Boolean.FALSE;

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

    public Flight(Long flightId, LocalDateTime departureDate, EnumFlight status, Integer ability,
                  String destination, Double price, String currencyCode, int occupiedSeats, Airport airport) {
        this.flightId = flightId;
        this.departureDate = departureDate;
        this.status = status;
        this.ability = ability;
        this.destination = destination;
        this.price = price;
        this.currencyCode = currencyCode;
        this.occupiedSeats = occupiedSeats;
        this.airport = airport;
    }

    public void addBooking(Booking booking){
        bookings.add(booking);
    }
    public void changeId(long idAirport){
        airport.setAirportId(idAirport);
    }
}
