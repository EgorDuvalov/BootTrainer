package com.innowise.boottrainer.controller;

import com.innowise.boottrainer.entity.User;
import com.innowise.boottrainer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/trainer")
public class CustomController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String welcomePage(@RequestParam(name = "name", defaultValue = "Guest") String name, Model model) {
        model.addAttribute("name", name);
        return "welcome";
    }

    @GetMapping("/add")
    public String addUser() {
        return "/add";
    }

    @PostMapping("/add")
    public String addUser(@RequestParam String login,
                          @RequestParam String pass,
                          @RequestParam String email) {
        User user = new User();
        user.setLogin(login);
        user.setPass(pass);
        user.setEmail(email);
        userRepository.save(user);
        return "add";
    }

    @PostMapping("/add")
    public String addUser(@RequestParam String login,
                          @RequestParam String pass,
                          @RequestParam String email) {
        User user = new User();
        user.setLogin(login);
        user.setPass(pass);
        user.setEmail(email);
        userRepository.save(user);
        return "add";
    }
}
