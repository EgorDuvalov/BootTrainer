package com.innowise.boottrainer.controller;

import com.innowise.boottrainer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller()
public class HomeController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String homePage(@RequestParam(name = "name", defaultValue = "Guest") String name,
                           Model model) {
        model.addAttribute("name", name);
        return "/home";
    }

    @GetMapping("/show")
    public String showUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "show";
    }
}
