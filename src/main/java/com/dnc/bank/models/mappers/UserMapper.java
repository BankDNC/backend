package com.dnc.bank.models.mappers;

import com.dnc.bank.models.documents.User;
import com.dnc.bank.models.request.UserRequest;
import com.dnc.bank.models.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User toUser(UserRequest userRequest) {
        return User.builder()
                .name(userRequest.getName())
                .lastName(userRequest.getLastName())
                .email(userRequest.getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .typeNit(userRequest.getTypeNit())
                .nit(userRequest.getNit())
                .phone(userRequest.getPhone())
                .build();
    }

    public UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
