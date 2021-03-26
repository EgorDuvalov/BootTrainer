package com.innowise.boottrainer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomController {

    @GetMapping("/")
    public String welcomePage(@RequestParam(name = "name", defaultValue = "Guest") String name, Model model) {
        model.addAttribute("name", name);
        return "welcome/welcome";
    }
}
