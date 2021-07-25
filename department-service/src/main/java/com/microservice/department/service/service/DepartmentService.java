package com.microservice.department.service.service;

import com.microservice.department.service.entity.Department;
import com.microservice.department.service.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department){
        log.info("Inside save department of department service");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("Inside find department by id of department service");
        return departmentRepository.findByDepartmentId(departmentId);
    }
}
