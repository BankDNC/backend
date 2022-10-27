package com.dnc.bank.controllers;

import com.dnc.bank.models.request.AuthRequest;
import com.dnc.bank.models.response.AuthResponse;
import com.dnc.bank.services.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
@Api(value = "Auth Controller", description = "Operations pertaining to Auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    @ApiOperation(value = "Login a user",
            response = AuthResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = Response.SC_OK, message = "Successfully logged in"),
            @ApiResponse(code = Response.SC_BAD_REQUEST, message = "Invalid credentials")
    })
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequest authRequest){
        return ResponseEntity.ok(authService.login(authRequest));
    }
}
