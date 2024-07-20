package com.example.Timesheet.controller;

import com.example.Timesheet.config.ApplicationProperties;
import com.example.Timesheet.entity.User;
import com.example.Timesheet.model.CredentialsDTO;
import com.example.Timesheet.model.CustomResponse;
import com.example.Timesheet.model.UserDTO;
import com.example.Timesheet.service.JwtService;
import com.example.Timesheet.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final ApplicationProperties applicationProperties;
    private final UserService userService;
    private final JwtService jwtService;

    @PostMapping
    @PreAuthorize("ADMIN")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    @PreAuthorize("ADMIN")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers_dto();
    }

    @PostMapping(value = "login")
    public CustomResponse login(@RequestBody CredentialsDTO credentials, HttpServletResponse res) {
        CustomResponse response = this.userService.login(credentials);
        if (response.isSuccess())
            res.setHeader(applicationProperties.getJwt().getHeader(), applicationProperties.getJwt().getBearer() + jwtService.generateToken(credentials.getEmail()));
        return response;
    }

    @PostMapping(value = "register")
    public CustomResponse register(@RequestBody CredentialsDTO credentials) {
        return this.userService.createUser(credentials);
    }
}
