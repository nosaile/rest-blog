package com.example.restblog.web;


import com.example.restblog.Services.UserService;
import com.example.restblog.data.Post;
import com.example.restblog.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Objects;


@CrossOrigin
@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostController{

    private final UserService userService;

    public PostController(UserService userService) {
        this.userService = userService;
    }

    public ArrayList<Post> setList() {
        return (ArrayList<Post>) userService.getPostList();
    }

    @GetMapping()
    public ArrayList<Post> getAll() {
        return setList();
    }

    @GetMapping("/{id}")
    public Post getById(@PathVariable Long id) {
        for (Post post : getAll()) {
            if (Objects.equals(id, post.getId())) {
                return post;
            }
        }
        return new Post();
    }

    @PostMapping
    public void createPost(@RequestBody Post postToAdd) {
        System.out.println(postToAdd);
    }

//    @PostMapping("")
//    public void create(@RequestBody Post post) {
//        Post postToAdd = new Post(
//                post.getId(),
//                post.getTitle(),
//                post.getContent()
//        );
//        System.out.println(postToAdd.getId());
//        System.out.println(postToAdd.getTitle());
//        System.out.println(postToAdd.getContent());
//    }

    @PutMapping("{id}")
    public void updatePost(@PathVariable Long id, @RequestBody Post post) {
//
    }

    @DeleteMapping("{id}")
    public void deletePost(@PathVariable Long id) {
//
    }
}
