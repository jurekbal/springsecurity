package com.balwinski.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFancyController {

    @GetMapping("/")
    public String getHome() {
        return "Home Page";
    }

    @GetMapping("/catalog")
    public String getCatalog() {
        return "Got it!";
    }

    @GetMapping("/help")
    public String getHelp() {
        return "Helpless";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "Admin Panel. Hello";
    }
}
