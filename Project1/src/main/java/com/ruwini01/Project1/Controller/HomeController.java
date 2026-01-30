package com.ruwini01.Project1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ruwini01.Project1.Models.Post;
import com.ruwini01.Project1.Services.PostService;

@Controller
public class HomeController {

    @Autowired
    private PostService postService;
    
    @GetMapping("/")
    public String home(Model model){
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "home";
    }


}
