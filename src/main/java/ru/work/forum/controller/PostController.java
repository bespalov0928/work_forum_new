package ru.work.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.work.forum.model.Answer;
import ru.work.forum.model.Post;
import ru.work.forum.model.User;
import ru.work.forum.service.AnswerService;
import ru.work.forum.service.PostService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostService postService;
    private final AnswerService answerService;

    public PostController(PostService postService, AnswerService answerService) {
        this.postService = postService;
        this.answerService = answerService;
    }

    @GetMapping("/read")
    public String read(@RequestParam("id") int id, Model model){
        model.addAttribute("post", postService.findById(id));
//        model.addAttribute("user", "_");
        return "read";
    }

    @GetMapping("/create")
    public String created(Model model){
//        model.addAttribute("user", "_");
        return "edit";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model){
        model.addAttribute("post", postService.findById(id));
        return "edit";
    }

    @PostMapping("/save")
//    public String save(@ModelAttribute Post post, @ModelAttribute Answer answer){
    public String save(@ModelAttribute Post post){
        User user = null;
        post.setUser(user);
        if (post.getId()==0){
            post.setAnswer(new ArrayList<Answer>());
//            postService.save(post);
        }else {
            Post postFind = postService.findById(post.getId());
            postFind.setDescription(post.getDescription());
            postFind.setCreated(post.getCreated());
            postFind.setUpdated(post.getUpdated());
//            postService.update(post);
        }
        return "redirect:/";
    }

    @PostMapping("/saveAnswer/{postId}")
    public String saveAnswer(@ModelAttribute Answer answer, @PathVariable("postId") int id){
        Post post = postService.findById(id);
        User user = null;
//        answer.setUser();
//        answerService.save(answer);

        List<Answer> answerList = post.getAnswer();
        answerList.add(answer);
        post.setAnswer(answerList);
        post.setUpdated(answer.getCreated());
//        postService.update(post);
        return "redirect/read?id="+id;
    }

}
