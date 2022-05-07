package com.staff.flight.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@MappedSuperclass
public class User implements UserDetails {

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email; // es el username
    @Column(nullable = false)
    private String password;
    @Column(name = "registration_Date")
    private Date registrationDate;
    @Column(unique = true)
    private String dni;
    private String country;

    @Column(name = "soft_delete")
    private boolean softDelete;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @Column(name = "role_id")
    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getRoles().stream().map(
                role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return isSoftDelete();
    }
}
