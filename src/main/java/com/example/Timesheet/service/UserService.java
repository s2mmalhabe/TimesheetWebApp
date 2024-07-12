package com.example.Timesheet.service;

import com.example.Timesheet.entity.Role;
import com.example.Timesheet.entity.User;
import com.example.Timesheet.model.CredentialsDTO;
import com.example.Timesheet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ModelMapper modelMapper = new ModelMapper();
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // TODO: When creating or changing an user, make sure that Email is unique, otherwise login will fail

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        return userRepository.save(user);
    }

    public User createUser(CredentialsDTO credentials) {
        return this.createUser(modelMapper.map(credentials, User.class));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}
