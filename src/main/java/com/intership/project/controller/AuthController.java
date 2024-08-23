package com.intership.project.controller;

import com.intership.project.model.User;
import com.intership.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userForm", userService.registerUser(new User()));
        return "user/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("userForm") User userForm, Model model) {
        if (!userForm.getPassword().equals(userForm.getConfirmPassword())) {
            model.addAttribute("passwordError", "Passwords do not match!");
            return "user/register";
        }

        if (userService.usernameExists(userForm.getUsername())) {
            model.addAttribute("usernameError", "Username already exists!");
            return "user/register";
        }

        userService.registerUser(userForm);
        return "redirect:/login";
    }
}