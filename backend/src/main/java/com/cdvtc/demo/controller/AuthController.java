package com.cdvtc.demo.controller;

import com.cdvtc.demo.common.Result;
import com.cdvtc.demo.dto.LoginRequest;
import com.cdvtc.demo.dto.RegisterRequest;
import com.cdvtc.demo.vo.LoginResponse;
import com.cdvtc.demo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/login")
    public Result<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        return Result.success(userService.login(request));
    }

    @PostMapping("/register")
    public Result<Void> register(@Valid @RequestBody RegisterRequest request) {
        userService.register(request);
        return Result.success();
    }
}
