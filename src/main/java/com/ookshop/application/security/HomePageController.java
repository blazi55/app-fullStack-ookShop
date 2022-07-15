package com.ookshop.application.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {

    @GetMapping("/home")
    public String homePage() {
        return "This is home Page";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "This is admin Page";
    }
}
