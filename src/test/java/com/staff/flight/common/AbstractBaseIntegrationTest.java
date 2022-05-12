package com.staff.flight.common;

import com.staff.flight.entity.Passenger;
import com.staff.flight.entity.Role;
import com.staff.flight.entity.User;
import com.staff.flight.repository.PassengerRepository;
import com.staff.flight.service.abstraction.RoleService;
import org.assertj.core.util.Lists;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;


public class AbstractBaseIntegrationTest {

    protected static final long PASSENGER_ID = 1L;

    protected TestRestTemplate restTemplate = new TestRestTemplate();
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
        String jwt = SecurityTestConfig.createToken("marzoa3581@gmail.com", role);
        headers.set("Authorization", jwt);
    }

    protected Role stubRole(String name) {
        Role role = new Role();
        role.setName(name);
        return role;
    }

    protected Passenger stubPassenger(String role){
       return new Passenger("Abel","Acevedo",
               "marzoa3581@gmail.com","12345678",null,
               "12345678","Argentina",false,Lists.list(stubRole(role)),
                PASSENGER_ID,null);

    }


}
