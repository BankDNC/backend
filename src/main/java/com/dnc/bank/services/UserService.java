package com.dnc.bank.services;

import com.dnc.bank.models.request.UserRequest;
import com.dnc.bank.models.response.InfoResponse;
import com.dnc.bank.models.response.UserResponse;

public interface UserService {
    UserResponse register(UserRequest user);

    InfoResponse info(String token);
}
