package com.ruwini01.Project1.Config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ruwini01.Project1.Models.Account;
import com.ruwini01.Project1.Models.Post;
import com.ruwini01.Project1.Services.AccountService;
import com.ruwini01.Project1.Services.PostService;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    @Override
    public void run(String... args) throws Exception {

        Account account01 = new Account();
        account01.setFirstName("account01");
        account01.setPassword("account01123");
        account01.setEmail("account01@example.com");

        Account account02 = new Account();
        account02.setFirstName("account02");
        account02.setPassword("account02123");
        account02.setEmail("account02@example.com");

        accountService.save(account01);
        accountService.save(account02);



        List<Post> posts = postService.getAllPosts();

        if (posts.isEmpty()) {
            Post post1 = new Post();
            post1.setTitle("First Post");
            post1.setAccount(account01);
            post1.setBody("This is the body of the first post.");
            postService.save(post1);

            Post post2 = new Post();
            post2.setTitle("Second Post");
            post2.setAccount(account02);
            post2.setBody("This is the body of the second post.");
            postService.save(post2);

            Post post3 = new Post();
            post3.setTitle("Third Post");
            post3.setAccount(account02);
            post3.setBody("This is the body of the third post.");
            postService.save(post3);

        }

    }

}
