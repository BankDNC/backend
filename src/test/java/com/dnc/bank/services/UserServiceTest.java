package com.dnc.bank.services;

import com.dnc.bank.catalogs.TypeNit;
import com.dnc.bank.exceptions.EmailExistException;
import com.dnc.bank.exceptions.NitExistException;
import com.dnc.bank.models.documents.User;
import com.dnc.bank.models.mappers.UserMapper;
import com.dnc.bank.models.request.UserRequest;
import com.dnc.bank.models.response.UserResponse;
import com.dnc.bank.repositories.UserRepository;
import com.dnc.bank.security.TokenUtils;
import com.dnc.bank.services.impl.UserServiceImpl;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private TokenUtils tokenUtils;
    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registerIsOk() {
        when(userRepository.existsByEmail(Mockito.anyString())).thenReturn(false);
        when(userRepository.existsByNit(Mockito.anyString())).thenReturn(false);
        when(userRepository.save(Mockito.any())).thenReturn(generateUser());
        when(userMapper.toUser(Mockito.any())).thenReturn(generateUser());
        when(userMapper.toUserResponse(Mockito.any())).thenReturn(generateUserResponse());

        assertNotNull(userService.register(generateUserRequest()));
    }

    private UserResponse generateUserResponse() {
        return UserResponse.builder()
                .id("1")
                .name("name")
                .email("email")
                .build();
    }

    @Test
    void registerEmailExist() {
        when(userRepository.existsByEmail(Mockito.anyString())).thenReturn(true);
        when(userRepository.existsByNit(Mockito.anyString())).thenReturn(false);

        assertThrows(EmailExistException.class, () -> userService.register(generateUserRequest()));
    }

    @Test
    void registerNitExist() {
        when(userRepository.existsByEmail(Mockito.anyString())).thenReturn(false);
        when(userRepository.existsByNit(Mockito.anyString())).thenReturn(true);

        assertThrows(NitExistException.class, () -> userService.register(generateUserRequest()));

    }

    @Test
    void getInfo(){
        when(tokenUtils.getEmail(Mockito.anyString())).thenReturn("test");
        when(userRepository.findByEmail(Mockito.any()))
                .thenReturn(java.util.Optional.of(generateUser()));

        assertNotNull(userService.info("token"));
    }

    @Test
    void getInfoThrow(){
        when(tokenUtils.getEmail(Mockito.anyString())).thenReturn("test");
        when(userRepository.findByEmail(Mockito.any()))
                .thenReturn(java.util.Optional.empty());

        assertThrows(RuntimeException.class, () -> userService.info("token"));
    }

    private UserRequest generateUserRequest() {
        return UserRequest.builder()
                .name("name")
                .lastName("lastName")
                .email("email")
                .password("password")
                .typeNit(TypeNit.CC)
                .nit("nit")
                .build();
    }

    private User generateUser(){
        return User.builder()
                .id("1")
                .name("name")
                .lastName("lastName")
                .email("email")
                .password("password")
                .typeNit(TypeNit.CC)
                .nit("nit")
                .build();
    }

}