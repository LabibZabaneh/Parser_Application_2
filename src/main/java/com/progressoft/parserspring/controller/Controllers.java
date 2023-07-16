package com.progressoft.parserspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Controllers {

    @GetMapping("/")
    public String hello(){
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(){
        return "upload";
    }

    @PostMapping("/upload")
    public String processUpload(){
        return "data";
    }
}
