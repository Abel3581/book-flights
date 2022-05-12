package com.staff.flight.integration;

import com.staff.flight.common.AbstractBaseIntegrationTest;
import com.staff.flight.common.SecurityTestConfig;
import com.staff.flight.config.JwtUtil;
import com.staff.flight.entity.Passenger;
import com.staff.flight.entity.User;
import com.staff.flight.entity.model.enums.ApplicationRole;
import com.staff.flight.entity.model.request.PassengerRegisterRequest;
import com.staff.flight.entity.model.response.PassengerRegisterResponse;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

import java.util.Objects;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RegisterPassengerIntegrationTest extends AbstractBaseIntegrationTest {

    private static final String PATH = "/auth/register";
    private String token = SecurityTestConfig.createToken(
            "marzoa3581@gmail.com", ApplicationRole.USER.getFullRoleName());
    @MockBean
    private JwtUtil jwtUtil;

    @Test
    public void shouldRegisterUserWithTokenSuccessfully(){
        Passenger user = stubPassenger(ApplicationRole.USER.getFullRoleName());
        when(passengerRepository.findByEmail(eq("marzoa3581@gmail.com"))).thenReturn(null);
        when(passengerRepository.save(isA(Passenger.class))).thenReturn(user);
        when(jwtUtil.generateToken(eq(user))).thenReturn(token);
        PassengerRegisterRequest request = new PassengerRegisterRequest();
        request.setFirstName("Abel");
        request.setLastName("Acevedo");
        request.setPassword("12345678");
        request.setEmail("marzoa3581@gmail.com");
        request.setCountry("Argentina");

        HttpEntity<PassengerRegisterRequest> entity = new HttpEntity<>(request, this.headers);
        ResponseEntity<PassengerRegisterResponse> response = this.restTemplate.exchange(
                createURLWithPort(PATH),
                HttpMethod.POST, entity, PassengerRegisterResponse.class);

        Assert.assertNotNull(response.getBody().getToken());
        Assert.assertEquals(Objects.requireNonNull(response.getBody()).getFirstName(), request.getFirstName());
        Assert.assertEquals(response.getBody().getLastName(), request.getLastName());
        Assert.assertEquals(response.getBody().getEmail(), request.getEmail());
        Assert.assertEquals(response.getBody().getCountry(),request.getCountry());
        Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());


    }


}
