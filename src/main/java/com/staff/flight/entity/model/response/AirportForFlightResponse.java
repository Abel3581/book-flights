package com.staff.flight.entity.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AirportForFlightResponse {

    private long id;
    private String name;
    private String code;
}
