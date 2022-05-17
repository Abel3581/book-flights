package com.staff.flight.entity;

import com.staff.flight.entity.model.enums.EnumBooking;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private Long bookingId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime issue;//fecha_emision

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime expiration;//fecha_vencimiento

    @Enumerated(value = EnumType.STRING)
    private EnumBooking conditions;

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    //@JsonIgnore
    @OneToOne(mappedBy = "booking",cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    private Passage passage;

    @ManyToOne
    //@JsonIgnore
    @JoinColumn(name = "flight_id")
    private Flight flight;

}
