package com.staff.flight.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
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
    private Long id;

    private Date date;

   // @Enumerated(value = EnumType.STRING)
  //  private EnumFlightStatus status;

    private Integer ability; //capacidad

    @Column(name = "airport_origin")
    private Integer origin;

    @Column(name = "airport_destination")
    private Integer destination;

    private BigDecimal price;

    @Column(name = "currency_code")
    private String currencyCode; //ARS, USD

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Booking> bookings = new ArrayList<>();

    public void addBooking(Booking booking){
        bookings.add(booking);
    }
}
