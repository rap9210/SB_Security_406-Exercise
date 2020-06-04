package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeControl {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @RequestMapping("/")
    public String home() {return "home";}

    @RequestMapping("/login")
    public String login(){return "login";}

    @PostMapping("/logout")
    public String logout(){return "redirect:/login?logout=true";}

    @RequestMapping("/admin")
    public String adminPage(Model model){
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("roles", roleRepository.findAll());
        return "admin";
    }

    @GetMapping("/newUser")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "newUser";
    }


}
