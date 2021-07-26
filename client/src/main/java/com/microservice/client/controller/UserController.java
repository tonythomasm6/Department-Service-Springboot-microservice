package com.microservice.client.controller;

import com.microservice.client.entity.User;
import com.microservice.client.service.DepartmentService;
import com.microservice.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService  userService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/users")
    public String getAllUsers(Model model){
            User[] users = userService.getAllUsers();
            model.addAttribute("allUsers", users);
            return "/user/userList";
    }

    @GetMapping("/users/addUser")
    public String addUser(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("allDepartments", departmentService.getAllDepartments());
        return "/user/addUser";
    }


    @PostMapping("/users/")
    public String addNewUser(User user, Model model){
        userService.addNewUser(user);
        return "redirect:/users";
    }
}
