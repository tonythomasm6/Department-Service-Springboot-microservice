package com.microservice.client.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private long userId;
    private String firstName;
    private String lastName;
    private String email;
    private Long departmentId;
}
