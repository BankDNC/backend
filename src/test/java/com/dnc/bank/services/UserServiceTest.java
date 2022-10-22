package com.dnc.bank.services;

import com.dnc.bank.catalogs.TypeNit;
import com.dnc.bank.exceptions.EmailExistException;
import com.dnc.bank.exceptions.NitExistException;
import com.dnc.bank.models.documents.User;
import com.dnc.bank.models.request.UserRequest;
import com.dnc.bank.repositories.UserRepository;
import com.dnc.bank.services.impl.UserServiceImpl;
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

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void registerIsOk() {
        when(userRepository.existsByEmail(Mockito.anyString())).thenReturn(false);
        when(userRepository.existsByNit(Mockito.anyString())).thenReturn(false);
        when(userRepository.save(Mockito.any())).thenReturn(generateUser());

        assertNotNull(userService.register(generateUserRequest()));

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