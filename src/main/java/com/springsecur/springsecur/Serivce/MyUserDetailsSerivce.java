package com.springsecur.springsecur.Serivce;

import com.springsecur.springsecur.Controllers.UserPrinicple;
import com.springsecur.springsecur.Model.Users;
import com.springsecur.springsecur.Repositry.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsSerivce implements UserDetailsService {

    @Autowired
    private UserRepo userrepo;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        Users user = userrepo.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not Found");
        }

        return new UserPrinicple(user);
    }
}