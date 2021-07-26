package com.microservice.client.service;

import com.microservice.client.entity.Department;
import com.microservice.client.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;
    @Value("${gatewayUrl}")
    private String gatewayUrl;

    public User[] getAllUsers() {
        return restTemplate.getForObject(gatewayUrl+"users/", User[].class);
    }

    public void addNewUser(User user) {
        User u = restTemplate.postForObject(gatewayUrl+"users/", user, User.class);
        System.out.println("User saved "+u);
    }
}
