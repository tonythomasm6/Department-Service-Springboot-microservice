package com.microservice.department.service.controller;

import com.microservice.department.service.entity.Department;
import com.microservice.department.service.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j  /*Loggin*/
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        log.info("Inside save department method of Department Control");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId){
        log.info("Inside find department by id");
        return departmentService.findDepartmentById(departmentId);
    }
//    @GetMapping("/test")
//    public String test(){
//        log.info("Inside find department by id");
//        return "Test query";
//    }

}
