package com.example.restblog.web;


import com.example.restblog.Services.UserService;
import com.example.restblog.data.Post;
import com.example.restblog.data.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }
//works
    @GetMapping
    public List<User> getAll(){
        return userService.getAllUsers();
    }
//works
    @GetMapping("{id}")
    public User getById(@PathVariable long id){
        return userService.getUserById(id);
    }
//rn I have to manually input a password field on swagger, not sure why yet
    @PostMapping
    public void create(@RequestBody User newUser){
        userService.addUser(newUser);
    }
//works
    @PostMapping("{username}")
    public void addUserPost(@PathVariable String username, @RequestBody Post newPost){
        userService.addPost(newPost, username);
    }
//works
    @GetMapping("username")
    public User getByUsername(@RequestParam String username) {
        return userService.getUserByUsername(username);
    }
//works
    @GetMapping("email")
    public User getByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }
//works
    @PutMapping("{id}/updatePassword")
    public void updatePassword(@PathVariable Long id, @RequestParam(required = false) String oldPassword, @Valid @Size(min = 3) @RequestParam String newPassword) {
        userService.updateUserPassword(id, newPassword);
    }



}




