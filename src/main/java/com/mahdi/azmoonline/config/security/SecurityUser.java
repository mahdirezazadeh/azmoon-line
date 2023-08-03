package com.mahdi.azmoonline.config.security;

import com.mahdi.azmoonline.base.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SecurityUser implements UserDetails {

    private UserEntity user;

    public SecurityUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<SimpleGrantedAuthority> roleAuthorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName())).toList();
        List<SimpleGrantedAuthority> operationAuthorities = user.getRoles().stream()
                .flatMap(roleEntity -> roleEntity.getOperations().stream())
                .map(operation -> new SimpleGrantedAuthority(operation.getName())).toList();
        authorities.addAll(roleAuthorities);
        authorities.addAll(operationAuthorities);
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.isActive();
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
        return !user.isDeleted();
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Long getId() {
        return user.getId();
    }
}
