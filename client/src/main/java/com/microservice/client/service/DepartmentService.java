package com.microservice.client.service;

import com.microservice.client.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DepartmentService {

    @Value("${gatewayUrl}")
    private String gatewayUrl;

    @Autowired
    private RestTemplate restTemplate;
    public Department[] getAllDepartments() {
        return restTemplate.getForObject(gatewayUrl+"departments/", Department[].class);

    }

    public void addDepartment(Department department) {
        Department d = restTemplate.postForObject(gatewayUrl+"departments/", department, Department.class);
        System.out.println("Department saved "+d);
    }
}
