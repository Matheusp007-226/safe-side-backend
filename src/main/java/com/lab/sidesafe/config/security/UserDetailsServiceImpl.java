package com.lab.sidesafe.config.security;

import com.lab.sidesafe.model.UserModel;
import com.lab.sidesafe.repositories.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRespository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserModel userModel = userRepository.findByName(userName).orElseThrow(
                () -> new UsernameNotFoundException(String.format("User %s not Found", userName))
        );
        return new User(userModel.getName(), userModel.getPassword(), true, true, true, true, userModel.getAuthorities());
    }


}
