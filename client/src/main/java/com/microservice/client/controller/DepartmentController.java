package com.microservice.client.controller;


import com.microservice.client.entity.Department;
import com.microservice.client.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public String goHome(){
        return "index";
    }


    @GetMapping("/departments")
    public String getAllDepartments(Model model){
            Department[] departments =  departmentService.getAllDepartments();
            model.addAttribute("allDepartments",departments);
            return "department/departmentList";

    }

    @GetMapping("/departments/addDepartment")
    public String addDepartment(Model model){
        model.addAttribute("department", new Department());
        return "department/addDepartment";
    }

    @PostMapping("/departments/department/")
    public String addNewDepartment(Department department, Model model){
        System.out.println("Add department ,"+department);
        departmentService.addDepartment(department);
        return "redirect:/departments";   /*Redirecting to get action to get all departments*/
    }
}
