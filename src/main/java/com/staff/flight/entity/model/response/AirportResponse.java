package com.staff.flight.entity.model.response;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AirportResponse {

    private String name;
    private String code;
}
