package com.mahdi.azmoonline.config.security;

import com.mahdi.azmoonline.base.entity.UserEntity;
import com.mahdi.azmoonline.manager.UserManager;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserManager userManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = userManager.findByUsername(username);
        if (user.isPresent())
            return new SecurityUser(user.get());
        else throw new UsernameNotFoundException("user " + username + " not found!");
    }
}
