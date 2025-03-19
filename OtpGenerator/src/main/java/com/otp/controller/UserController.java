package com.otp.controller;

import com.otp.model.User;
import com.otp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        boolean isRegistered = userService.registerUser(user);

        if (isRegistered) {
            return ResponseEntity.ok("OTP sent to " + user.getEmail() + ". Verify to complete registration.");
        } else {
            return ResponseEntity.badRequest().body("Registration failed. Please try again.");
        }
    }
    
    @GetMapping("/login")
    public String login(Model model)
    {
    	model.addAttribute("message", "Hey there!");
    	return "otp_verification";
    }
}
