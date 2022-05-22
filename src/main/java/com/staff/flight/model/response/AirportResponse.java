package com.staff.flight.model.response;

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
