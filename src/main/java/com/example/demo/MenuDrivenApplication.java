package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
public class MenuDrivenApplication {

    public static void main(String[] args) {
        SpringApplication.run(MenuDrivenApplication.class, args);
    }

    @Controller
    public static class UserController {

        @GetMapping("/")
        public String showMenu() {
            return "menu";
        }

        @PostMapping("/login")
        public String loginUser(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                Model model) {
            // Perform login logic here
            // You can check the username and password against a database or any other authentication mechanism

            model.addAttribute("message", "Login successful!");
            return "menu";
        }

        @PostMapping("/register")
        public String registerNewUser(@RequestParam("username") String username,
                                      @RequestParam("firstName") String firstName,
                                      @RequestParam("lastName") String lastName,
                                      @RequestParam("email") String email,
                                      @RequestParam("password") String password,
                                      Model model) {
            // Perform new user registration logic here
            // You can store the user details in a database or any other data store

            model.addAttribute("message", "You have successfully registered as a new user!");
            return "menu";
        }

        @PostMapping("/forgot-password")
        public String forgotPassword(@RequestParam("username") String username,
                                     @RequestParam("email") String email,
                                     Model model) {
            // Perform forgot password logic here
            // You can send a password reset link to the user's email

            model.addAttribute("message", "An email has been sent to your registered email address with further instructions.");
            return "menu";
        }
    }
}
