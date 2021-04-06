package com.kc.fashion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository repository;


    @Autowired
    BCryptPasswordEncoder passwordEncoder;



    public UserServiceImpl() {

    }

    @Override
    public User save(User userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
            return repository.save(userDto);
    }
}
