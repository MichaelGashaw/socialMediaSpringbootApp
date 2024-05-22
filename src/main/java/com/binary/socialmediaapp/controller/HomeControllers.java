package com.binary.socialmediaapp.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeControllers {
    @GetMapping("/")
    public String showHomePage (Model model) {
        return "index";
    }
}
