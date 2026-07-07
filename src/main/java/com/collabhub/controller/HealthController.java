package com.collabhub.controller;

import com.collabhub.dto.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/api/health")
    public ApiResponse<Object> health() {
        return new ApiResponse<>(
                true,
                "Backend is running",
                null
        );
    }
}
