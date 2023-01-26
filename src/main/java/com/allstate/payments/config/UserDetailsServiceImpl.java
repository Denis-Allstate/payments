package com.allstate.payments.config;

import com.allstate.payments.data.UserRepository;
import com.allstate.payments.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if(!optionalUser.isPresent()) throw new UsernameNotFoundException(username);
        User user = optionalUser.get();
        System.out.println(user);
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority("ROLE_" +user.getRole().toString()));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), roles);
    }
}
