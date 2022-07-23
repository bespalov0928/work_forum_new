package ru.work.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.work.forum.model.Authority;
import ru.work.forum.model.User;
import ru.work.forum.service.AuthorityService;
import ru.work.forum.service.UserService;

@Controller
public class RegController {

    private final UserService userService;
    private final AuthorityService authorityService;

    public RegController(UserService userService, AuthorityService authorityService) {
        this.userService = userService;
        this.authorityService = authorityService;
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
//        user.setAuthority(authorityService.findByAuthority("ROLE_USER"));
        user.setPassword("");
//            userService.save(user);
        return "redirect:/login";

    }

    @GetMapping("/reg")
    public String regPage() {
        return "reg";
    }
}
