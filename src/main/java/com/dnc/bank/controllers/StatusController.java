package com.dnc.bank.controllers;

import com.dnc.bank.models.response.StatusResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StatusController {

    @GetMapping
    @ApiOperation(value = "Get status of the application",
            response = StatusResponse.class)
    @ApiResponse(code = 200, message = "Successfully retrieved status")
    public ResponseEntity<StatusResponse> statusBase() {
        return ResponseEntity.ok(getOk());
    }

    @GetMapping("/status")
    @ApiOperation(value = "Get status of the application",
            response = StatusResponse.class)
    @ApiResponse(code = 200, message = "Successfully retrieved status")
    public ResponseEntity<StatusResponse> status() {
        return ResponseEntity.ok(getOk());
    }

    private static StatusResponse getOk() {
        return StatusResponse.builder().message("OK").build();
    }

}
