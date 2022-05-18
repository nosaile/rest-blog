package com.example.restblog.web;


import com.example.restblog.data.Post;
import com.example.restblog.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {

    ArrayList<User> users = new ArrayList<>();
    User user1 = new User(1, "nosaile", "1email@web.com", "pass1", new Date(2005 - 10 - 10), User.Role.ADMIN);
    User user2 = new User(2, "sirhc", "2email@web.com", "pass2", new Date(2005 - 10 - 10), User.Role.USER);
    User user3 = new User(3, "topherson", "3email@web.com", "pass3", new Date(2005 - 10 - 10), User.Role.USER);
    User user4 = new User(4, "player1", "4email@web.com", "pass4", new Date(2005 - 10 - 10), User.Role.USER);
    User user5 = new User(5, "player2", "5email@web.com", "pass5", new Date(2005 - 10 - 10), User.Role.USER);

    @GetMapping
    public ArrayList<User> getAll() {
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        return users;
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        for (User user : getAll()) {
            if (Objects.equals(id, user.getId())) {
                return user;
            }
        }
        return new User();
    }

    @PostMapping("")
    public void createUser(@RequestBody User user) {
        User userToCreate = new User(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getCreatedAt(),
                user.getRole()
        );
        System.out.println(userToCreate.getId());
        System.out.println(userToCreate.getUsername());
        System.out.println(userToCreate.getEmail());
        System.out.println(userToCreate.getPassword());
        System.out.println(userToCreate.getCreatedAt());
        System.out.println(userToCreate.getRole());

    }

    @PutMapping("{id}")
    public void updatePost(@PathVariable Long id, @RequestBody User user) {
        System.out.println("Updated user with id: " + id + ".");
        System.out.println(user);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id) {
        System.out.println("Deleted user with id: " + id);
    }
}




