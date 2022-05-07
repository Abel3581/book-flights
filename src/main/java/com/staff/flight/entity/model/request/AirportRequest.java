package com.staff.flight.entity.model.request;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class AirportRequest {

    private String name;
    private String code;
}
