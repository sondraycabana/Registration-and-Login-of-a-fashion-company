package com.kc.fashion;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEndoder {
    public  static void main(String[]args){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "password";
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println(encodedPassword);
    }
}
