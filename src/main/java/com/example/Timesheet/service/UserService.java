package com.example.Timesheet.service;

import com.example.Timesheet.entity.Role;
import com.example.Timesheet.entity.User;
import com.example.Timesheet.model.CredentialsDTO;
import com.example.Timesheet.model.CustomResponse;
import com.example.Timesheet.model.UserDTO;
import com.example.Timesheet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ModelMapper modelMapper = new ModelMapper();
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public CustomResponse login(CredentialsDTO credentials) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credentials.getEmail(), credentials.getPassword()));
        return new CustomResponse(authentication.isAuthenticated());
    }

    public User createUser(User user) {
        if (this.doesUserExist(user.getEmail()))
            return null;
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        return userRepository.save(user);
    }

    public User createUser(CredentialsDTO credentials) {
        return this.createUser(modelMapper.map(credentials, User.class));
    }

    private List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<UserDTO> getAllUsers_dto() {
        List<User> users = this.getAllUsers();
        List<UserDTO> dtos = new ArrayList<>();
        for (User user : users)
            dtos.add(modelMapper.map(user, UserDTO.class));
        return dtos;
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    private boolean doesUserExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
