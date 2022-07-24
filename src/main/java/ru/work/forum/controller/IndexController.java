package ru.work.forum.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ru.work.forum.service.AnswerService;
import ru.work.forum.service.PostService;

@Controller
public class IndexController {
    private final PostService postService;
    private final AnswerService answerService;

    public IndexController(PostService postService, AnswerService answerService) {
        this.postService = postService;
        this.answerService = answerService;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("posts", postService.findAll());
        model.addAttribute("answers", answerService.findAll());
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "index";
    }

}
