package com.dnc.bank.controllers;

import com.dnc.bank.models.request.UserRequest;
import com.dnc.bank.models.response.InfoResponse;
import com.dnc.bank.models.response.UserResponse;
import com.dnc.bank.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody UserRequest user){
        return ResponseEntity.ok(userService.register(user));
    }

    @GetMapping("/info")
    public ResponseEntity<InfoResponse> info(@RequestHeader("Authorization") String token){
        return ResponseEntity.ok(userService.info(token));
    }
}
