package com.staff.flight.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@SQLDelete(sql = "UPDATE airport SET soft_delete=true airport_id=?")
@Where(clause = "soft_delete=false")
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

    @Column(name = "soft_delete")
    private boolean softDelete = Boolean.FALSE;

    @OneToMany(mappedBy = "airport", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Flight> flights = new ArrayList<>();

    public void addFlights(Flight flight){
        flights.add(flight);
    }

    public boolean airportContains(LocalDateTime localDateTime){
      for (Flight f: flights){
          if(f.getDepartureDate().equals(localDateTime)){
              return true;
          }
      }
      return false;
    }

}
