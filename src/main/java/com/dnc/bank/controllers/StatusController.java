package com.dnc.bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping("/status")
    public String status() {
        return "OK";
    }

    @GetMapping("/status/token")
    public String statusToken() {
        return "OK";
    }
}
