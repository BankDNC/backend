package com.dnc.bank.services.impl;

import com.dnc.bank.exceptions.EmailExistException;
import com.dnc.bank.exceptions.NitExistException;
import com.dnc.bank.exceptions.NotFoundException;
import com.dnc.bank.models.documents.User;
import com.dnc.bank.models.mappers.UserMapper;
import com.dnc.bank.models.request.UserRequest;
import com.dnc.bank.models.response.InfoResponse;
import com.dnc.bank.models.response.UserResponse;
import com.dnc.bank.repositories.UserRepository;
import com.dnc.bank.security.TokenUtils;
import com.dnc.bank.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.dnc.bank.exceptions.ExceptionConstant.*;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private TokenUtils tokenUtils;
    private UserMapper userMapper;

    @Override
    public UserResponse register(UserRequest userRequest) {
        validRegister(userRequest);

        User userDocument = userMapper.toUser(userRequest);
        User user = userRepository.save(userDocument);
        return userMapper.toUserResponse(user);
    }

    @Override
    public InfoResponse info(String token) {
        token = token.replace("Bearer ", "");
        String email = tokenUtils.getEmail(token);
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException(USER_NOT_FOUND));
        InfoResponse infoResponse = new InfoResponse();

        infoResponse.setUserResponse(userMapper.toUserResponse(user));

        return infoResponse;

    }

    private void validRegister(UserRequest userRequest) {
        if(userRepository.existsByEmail(userRequest.getEmail())){
            throw new EmailExistException(EMAIL_EXIST);
        }

        if(userRepository.existsByNit(userRequest.getNit())){
            throw new NitExistException(NIT_EXIST);
        }
    }
}
