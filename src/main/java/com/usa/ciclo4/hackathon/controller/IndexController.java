package com.usa.ciclo4.hackathon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "vistas/index";
    }

    @GetMapping("/login")
    public String login() {
        return "vistas/login";
    }

    @GetMapping("/register")
    public String register() {
        return "vistas/register";
    }

    @GetMapping("/home")
    public String homePage() {
        return "vistas/home";
    }

    @GetMapping("/community")
    public String communityPage() {
        return "vistas/community";
    }
}
