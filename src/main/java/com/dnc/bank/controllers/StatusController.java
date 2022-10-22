package com.dnc.bank.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping("/status")
    @ApiOperation(value = "Get status of the application",
            response = String.class)
    @ApiResponse(code = 200, message = "Successfully retrieved status")
    public String status() {
        return "OK";
    }

}
