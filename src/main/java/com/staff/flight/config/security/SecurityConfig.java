package com.staff.flight.config.security;


import com.staff.flight.config.JwtRequestFilters;
import lombok.RequiredArgsConstructor;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtRequestFilters jwtRequestFilters;

    @Bean
    public BCryptPasswordEncoder passwordEncoder (){return new BCryptPasswordEncoder();}
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .cors()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/airport").permitAll()
                .antMatchers(HttpMethod.GET,"/airport/{id}").permitAll()
                .antMatchers(HttpMethod.DELETE,"/airport/{id}").permitAll()
                .antMatchers(HttpMethod.PUT,"/airport/{id}").permitAll()
                .antMatchers(HttpMethod.POST,"/auth/register").permitAll()
                .antMatchers(HttpMethod.POST,"/auth/login").permitAll()
                .antMatchers(HttpMethod.GET,"/auth/me").permitAll()
                .antMatchers(HttpMethod.GET,"/auth/mee").permitAll()
                .antMatchers(HttpMethod.POST,"/flight").permitAll()
                .antMatchers(HttpMethod.GET,"/flight/{id}").permitAll()
                .antMatchers(HttpMethod.DELETE,"/flight/{id}").permitAll()
                .antMatchers(HttpMethod.PUT,"/flight/{id}").permitAll()
                .antMatchers(HttpMethod.GET,"/flight/all").permitAll()
                .antMatchers(HttpMethod.GET,"/flight/destination").permitAll()
                .antMatchers(HttpMethod.POST,"/booking/save").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .addFilterBefore(jwtRequestFilters, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling()
                .authenticationEntryPoint(new Http403ForbiddenEntryPoint());
    }

}
