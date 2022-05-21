package com.staff.flight.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.staff.flight.entity.model.enums.EnumBooking;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

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

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    private LocalDateTime dateOfIssue;//fecha_emision

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    private LocalDateTime expiration;//fecha_vencimiento

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    private LocalDateTime departureDate;//fecha de salida

    @Enumerated(value = EnumType.STRING)
    private EnumBooking conditions;

    private double payment;

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    @OneToOne(mappedBy = "booking",cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    private Passage passage;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(bookingId, booking.bookingId) &&
                Objects.equals(dateOfIssue, booking.dateOfIssue)
                && Objects.equals(expiration, booking.expiration)
                && Objects.equals(departureDate, booking.departureDate)
                && conditions == booking.conditions && Objects.equals(passenger, booking.passenger)
                && Objects.equals(passage, booking.passage) && Objects.equals(flight, booking.flight);
    }


}
