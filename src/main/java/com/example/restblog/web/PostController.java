package com.example.restblog.web;

import com.example.restblog.Services.EmailService;
import com.example.restblog.Services.PostService;
import com.example.restblog.data.Post;
import com.example.restblog.Services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostController {

    private final PostService postService;
    private final UserService userService;
    private final EmailService emailService;


    public PostController(PostService postService, EmailService emailService, UserService userService) {
        this.postService = postService;
        this.emailService = emailService;
        this.userService = userService;
    }

    //works
    @GetMapping
    public List<Post> getAll() {
        return postService.getAllPosts();
    }

    //works
    @GetMapping("{id}")
    public Post getById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

//might come back to this but right now I don't want to implement this
//    @PostMapping
//    public void createPost(@RequestBody Post postToAdd) {
//        System.out.println(postToAdd);
//    }

    //works
    @PostMapping("{username}")
    public void createByUsername(@PathVariable String username, @RequestBody Post newPost) {
        userService.addPost(newPost, username);
        emailService.prepareAndSend(newPost, "New post created.", "Here is your new post: '" + newPost.getContent() + "'");

    }

    //works
    @PutMapping("{id}")
    public void updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {
        postService.updatePost(id, updatedPost);
    }

    //works
    @DeleteMapping("{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePostById(id);
    }

    //works
    @GetMapping("search")
    public List<Post> searchPosts(@RequestParam String keyword) {
        return postService.getPostsByTitleKeyword(keyword);
    }


}
