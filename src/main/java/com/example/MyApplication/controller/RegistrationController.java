package com.example.MyApplication.controller;

import com.example.MyApplication.entity.Role;
import com.example.MyApplication.entity.User;
import com.example.MyApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/registration")
    public String registration(Map<String, Object> model){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute User user, Map<String, Object> model){
        User UserFromDB = userRepository.findByUsername(user.getUsername());

        if(UserFromDB != null){
            model.put("message", "User exists");
            return "registration";

        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword("{noop}" + user.getPassword());
        userRepository.save(user);

        return "redirect:/login";
    }
}
