package com.staff.flight.entity.model.response;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
public class PassengerAuthenticatedResponse {
    private String token;
    private String email;
    private Collection<? extends GrantedAuthority> getAuthorities;

    public PassengerAuthenticatedResponse(String token, String email, Collection<? extends GrantedAuthority> getAuthorities) {
        this.token = token;
        this.email = email;
        this.getAuthorities = getAuthorities;
    }

}
