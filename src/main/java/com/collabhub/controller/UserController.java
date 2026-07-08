package com.collabhub.controller;

import com.collabhub.dto.ApiResponse;
import com.collabhub.dto.CreateUserRequest;
import com.collabhub.dto.UserResponse;
import com.collabhub.entity.User;
import com.collabhub.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

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
    public ApiResponse<UserResponse> createUser( @RequestBody @Valid CreateUserRequest request){
        UserResponse response = userService.createUser(request);

        return new ApiResponse<>(
                true,
                "User created successfully",
                response
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<UserResponse> getUserById(@PathVariable Long id){
        UserResponse response = userService.getUserById(id);

        return new ApiResponse<>(
                true,
                "User fetched successfully",
                response
        );
    }

    @GetMapping("/ping")
    public String ping(){
        return "ping";
    }
}
