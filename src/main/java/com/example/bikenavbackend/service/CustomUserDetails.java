package com.example.bikenavbackend.service;

import com.example.bikenavbackend.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private final Long id;
    private final String email;
    private final String passwordHash;
    private final String name;

    public CustomUserDetails(Long id, String email, String passwordHash, String name) {
        this.id = id;
        this.email = email;
        this.passwordHash = passwordHash;
        this.name = name;
    }

    public static CustomUserDetails from(UserEntity user) {
        return new CustomUserDetails(user.getId(), user.getEmail(), user.getPasswordHash(), user.getName());
    }

    public Long getId() { return id; }
    public String getName() { return name; }

    @Override public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override public String getPassword() { return passwordHash; }
    @Override public String getUsername() { return email; }
    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }
}
