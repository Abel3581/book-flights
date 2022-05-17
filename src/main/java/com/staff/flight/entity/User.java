package com.staff.flight.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class User implements UserDetails {

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @NotBlank(message = "Email cannot be empty.")
    @Column(unique = true, nullable = false)
    private String email; // es el username
    @NotBlank(message = "Password cannot be empty.")
    @Size(min = 8, max = 250, message = "Password should have at least 8 characters")
    private String password;
    @CreationTimestamp
    private Timestamp timestamp;
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
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !this.softDelete;
    }
}
