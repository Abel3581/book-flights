package com.staff.flight.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "passage")
public class Passage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passage_id")
    private Long id;

    private Long idPassenger;

    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    private LocalDateTime issue;//emision

    @Column(name = "payment_info")
    private boolean paymentInfo;//info pago
}
