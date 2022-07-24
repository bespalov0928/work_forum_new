package ru.work.forum.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.work.forum.model.Role;
import ru.work.forum.model.User;
import ru.work.forum.service.AuthorityService;
import ru.work.forum.service.UserService;

@Controller
public class RegController {

    private final UserService userService;
    private final AuthorityService authorityService;
    private final PasswordEncoder passwordEncoder;


    public RegController(UserService userService, AuthorityService authorityService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.authorityService = authorityService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/reg")
    public String reqSave(@ModelAttribute User user, Model model) {
        User userFind = userService.findByUsername(user.getUsername());
        if (userFind != null) {
            String errorMessage = "User exists!";
            model.addAttribute("errorMessage", errorMessage);
            return "reg";
        }

        user.setEnabled(true);
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return "login";

    }

    @GetMapping("/reg")
    public String regPage() {
        return "reg";
    }
}
