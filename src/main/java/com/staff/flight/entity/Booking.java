package com.staff.flight.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long id;

    private Date issue;//fecha_emision

    private Date expiration;//fecha_vencimiento

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    //@JsonIgnore
    @OneToOne(mappedBy = "booking",cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    private Passage passage;

}
