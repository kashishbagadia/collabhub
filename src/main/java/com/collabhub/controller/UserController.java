package com.collabhub.controller;

import com.collabhub.dto.CreateUserRequest;
import com.collabhub.dto.UserResponse;
import com.collabhub.entity.User;
import com.collabhub.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public UserResponse createUser( @Valid @RequestBody CreateUserRequest request){
        return userService.createUser(request);
    }

    @GetMapping("/ping")
    public String ping(){
        return "ping";
    }
}
