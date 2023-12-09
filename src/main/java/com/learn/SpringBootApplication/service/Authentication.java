package com.learn.SpringBootApplication.service;

import org.springframework.stereotype.Service;

@Service
public class Authentication {
    //Window for login
    public boolean authenticate(String name,String password){
        return name.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin");
    }

}
