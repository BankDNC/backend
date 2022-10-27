package com.dnc.bank.controllers;

import com.dnc.bank.models.request.UserRequest;
import com.dnc.bank.models.response.InfoResponse;
import com.dnc.bank.models.response.UserResponse;
import com.dnc.bank.services.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ApiOperation(value = "Register a user",
            response = UserResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = Response.SC_OK, message = "Successfully registered user"),
            @ApiResponse(code = Response.SC_BAD_REQUEST, message = "Invalid request")
    })
    public ResponseEntity<UserResponse> register(@Valid @RequestBody UserRequest user){
        return ResponseEntity.ok(userService.register(user));
    }

    @GetMapping("/info")
    @ApiOperation(value = "Get user info",
            response = InfoResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = Response.SC_OK, message = "Successfully retrieved user info"),
            @ApiResponse(code = Response.SC_BAD_REQUEST, message = "Invalid request")
    })
    public ResponseEntity<InfoResponse> info(@RequestHeader("Authorization") String token){
        return ResponseEntity.ok(userService.info(token));
    }
}
