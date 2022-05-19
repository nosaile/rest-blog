package com.example.restblog.web;


import com.example.restblog.data.Post;
import com.example.restblog.data.User;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;


@CrossOrigin
@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostController{
    ArrayList<Post> posts = new ArrayList<>();
    Post newPost1 = new Post(1L, "The first Post.", "This will be the very first post in the list.");
    Post newPost2 = new Post(2L, "The second Post.", "This will be the second post in the list.");
    Post newPost3 = new Post(3L, "The third Post.", "This will be the third post in the list.");
    Post newPost4 = new Post(4L, "A brand new Post!!!", "This post is brand spanking new!");


    public ArrayList<Post> setList() {
//        newPost1.setUser(new User(6L, "user6", "6@mail.com", "1234567890", LocalDateTime.now(), User.Role.USER));
//        newPost2.setUser(new User(6L, "user6", "6@mail.com", "1234567890", LocalDateTime.now(), User.Role.USER));
//        newPost3.setUser(new User(7L, "7thUSER", "7@mail.com", "ytfcvbh", LocalDateTime.now(), User.Role.USER));
//        newPost4.setUser(new User(8L, "ATEthUser", "8@mail.com", "passwoo0ord", LocalDateTime.now(), User.Role.USER));
        posts.add(newPost1);
        posts.add(newPost2);
        posts.add(newPost3);
        posts.add(newPost4);
        return posts;
    }

    @GetMapping()
    public ArrayList<Post> getAll() {
        posts.removeAll(posts);
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

    @PostMapping("")
    public void create(@RequestBody Post post) {
        Post postToAdd = new Post(
                post.getId(),
                post.getTitle(),
                post.getContent()
        );
        System.out.println(postToAdd.getId());
        System.out.println(postToAdd.getTitle());
        System.out.println(postToAdd.getContent());
    }

    @PutMapping("{id}")
    public void updatePost(@PathVariable Long id, @RequestBody Post post) {
//        System.out.println("Updated post.");
    }

    @DeleteMapping("{id}")
    public void deletePost(@PathVariable Long id) {
//        System.out.println("Deleting post with id: " + id);
    }
}
