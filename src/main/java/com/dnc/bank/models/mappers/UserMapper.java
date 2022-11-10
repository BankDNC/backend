package com.dnc.bank.models.mappers;

import com.dnc.bank.models.documents.User;
import com.dnc.bank.models.request.UserRequest;
import com.dnc.bank.models.response.UserResponse;

public class UserMapper {
    public static User toUser(UserRequest userRequest) {
        return User.builder()
                .name(userRequest.getName())
                .lastName(userRequest.getLastName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .typeNit(userRequest.getTypeNit())
                .nit(userRequest.getNit())
                .phone(userRequest.getPhone())
                .build();
    }

    public static UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
