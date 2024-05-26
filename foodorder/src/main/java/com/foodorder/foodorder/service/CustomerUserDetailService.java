package com.foodorder.foodorder.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.foodorder.foodorder.entity.CustomerUserDetail;
import com.foodorder.foodorder.entity.User;
import com.foodorder.foodorder.repository.UserRepository;

@Service
public class CustomerUserDetailService implements  UserDetailsService{

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Optional<User> user = userRepository.findUserByEmail(email);
        user.orElseThrow(()-> new UsernameNotFoundException("username not found"));

        return user.map(CustomerUserDetail::new).get();
    }

}
