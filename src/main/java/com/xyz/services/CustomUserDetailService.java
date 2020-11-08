package com.xyz.services;

import com.xyz.repository.UserRepository;
import com.xyz.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /*
     * At the time of login this method invoke and customer validation will
     * happen
     */
    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        User admin = userRepository.findByEmailId(emailId);
        return new org.springframework.security.core.userdetails.User(admin.getEmailId(), admin.getPassword(), new ArrayList<>());
    }

}
