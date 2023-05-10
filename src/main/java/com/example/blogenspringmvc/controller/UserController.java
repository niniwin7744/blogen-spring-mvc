package com.example.blogenspringmvc.controller;

import com.example.blogenspringmvc.entity.Users;
import com.example.blogenspringmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/save-users")
    public String saveUser(Users users, BindingResult result){
        if(result.hasErrors()){
            return "home";
        }
        userService.saveUser(users);
        return "redirect:/";
    }
    @GetMapping("/save-users")
    public String createUser(Model model){
        model.addAttribute("user",new Users());
        return "home";
    }
    @GetMapping("/list-users")
    public String listAllUsers(Model model){
        model.addAttribute("allUsers",userService.findAllUsers());
        return "userList";
    }
}
