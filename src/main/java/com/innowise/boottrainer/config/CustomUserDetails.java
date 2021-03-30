package com.innowise.boottrainer.config;

import com.innowise.boottrainer.entity.Role;
import com.innowise.boottrainer.entity.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Data
public class CustomUserDetails implements UserDetails {
    private String username;
    private String password;
    private String email;
//    private List<Role> authorities;


    public CustomUserDetails(String username) {
        this.username = username;
        this.password = "pass";
    }

    public CustomUserDetails(User user) {
        this.password = user.getPass();
        this.username = user.getUsername();
        this.email = user.getEmail();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
        return true;
    }
}
