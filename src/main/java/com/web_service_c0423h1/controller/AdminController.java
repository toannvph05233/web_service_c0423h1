package com.web_service_c0423h1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/admins")
public class AdminController {
    @GetMapping
    public String admin(){
        return "đây la admin";
    }
}