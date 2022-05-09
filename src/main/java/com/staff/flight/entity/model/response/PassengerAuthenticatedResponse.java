package com.staff.flight.entity.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class PassengerAuthenticatedResponse {
    private String token;
    private String email;

    public PassengerAuthenticatedResponse(String token, String email){
        this.token = token;
        this.email = email;

    }
}
