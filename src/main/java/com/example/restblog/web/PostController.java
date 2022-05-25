package com.example.restblog.web;

import com.example.restblog.Services.EmailService;
import com.example.restblog.data.Post;
import com.example.restblog.Services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostController {

    private final UserService userService;
    private final EmailService emailService;


    public PostController(UserService userService, EmailService emailService){
        this.userService = userService;
        this.emailService = emailService;
    }
//works
    @GetMapping
    public List<Post> getAll() {
        return userService.getAllPosts();
    }
//works
    @GetMapping("{id}")
    public Post getById(@PathVariable Long id) {
        return userService.getPostById(id);
    }
//might come back to this but right now I don't want to implement this
//    @PostMapping
//    public void createPost(@RequestBody Post postToAdd) {
//        System.out.println(postToAdd);
//    }

//works
    @PostMapping("{username}")
    public void createByUsername(@PathVariable String username, @RequestBody Post newPost){
        userService.addPost(newPost, username);
        emailService.prepareAndSend(newPost, newPost.getTitle(), newPost.getContent());

    }
//works
    @PutMapping("{id}")
    public void updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {
        userService.updatePost(id, updatedPost);
    }
//works
    @DeleteMapping("{id}")
    public void deletePost(@PathVariable Long id) {
        userService.deletePostById(id);
    }
//works
    @GetMapping("search")
    public List<Post> searchPosts(@RequestParam String keyword) {
        return userService.getPostsByTitleKeyword(keyword);
    }

}
