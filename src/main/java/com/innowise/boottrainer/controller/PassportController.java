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
@RequestMapping("/passport")
public class PassportController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String addUser() {
        return "passport/registration";
    }

    @PostMapping("/registration")
    public String addUser(@RequestParam String login,
                          @RequestParam String pass,
                          @RequestParam String email,
                          Model model
    ) {
        if (userRepository.findByLogin(login) != null) {
            model.addAttribute("message", "User already exists");
            return "passport/registration";
        }
        User user = new User(login, pass, email);
        userRepository.save(user);
        return "redirect:/passport/login";
    }


//    @GetMapping("/login")
//    public String addUser() {
//        return "passport/login";
//    }
//
//    @PostMapping("/login")
//    public String addUser(@RequestParam String login,
//                          @RequestParam String pass,
//                          @RequestParam String email) {
//        userRepository.save(new User(login, pass, email));
//        return "passport/login";
//    }
}
