package com.staff.flight.entity.model.response;

import com.staff.flight.entity.Flight;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AirportResponse {
    private long id;
    private String name;
    private String code;
    private List<FlightResponse> flightList;
}
