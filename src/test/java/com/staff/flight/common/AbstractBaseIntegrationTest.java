package com.staff.flight.common;

import com.staff.flight.repository.PassengerRepository;
import com.staff.flight.service.abstraction.RoleService;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;

public class AbstractBaseIntegrationTest {

    protected static final long PASSENGER_ID = 1L;

    protected TestRestTemplate testRestTemplate = new TestRestTemplate();
    protected org.springframework.http.HttpHeaders headers = new HttpHeaders();

    @MockBean
    protected PassengerRepository passengerRepository;

    @MockBean
    protected AuthenticationManager authenticationManager;

    @MockBean
    protected RoleService roleService;

    @LocalServerPort
    protected int port;

    protected String createURLWithPort(String uri){
        return "http://localhost:" + port + uri;
    }

    protected void setAuthorizationHeaderBasedOn(String role) {
        String jwt = SecurityTestConfig.createToken("email@gmail.com", role);
        headers.set("Authorization", jwt);
    }












}
