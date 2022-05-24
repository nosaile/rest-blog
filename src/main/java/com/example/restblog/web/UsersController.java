package com.example.restblog.web;


import com.example.restblog.Services.UserService;
import com.example.restblog.data.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {


    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

//    public ArrayList<User> setList() {
//        userService.setUserList();
//        return (ArrayList<User>) userService.getUserList();
//    }

    @GetMapping
    public List<User> getAll() {
        return  userService.getUserList();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/username")
    public User getByUserName(@RequestParam String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping("/email")
    public User getByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping
    public void createUser(@RequestBody User newUser){
        userService.getUserList().add(newUser);
        userService.usersRepository.save(newUser);
    }

//    @PostMapping("")
//    public void createUser(@RequestBody User user) {
//        User userToCreate = new User(
//                user.getId(),
//                user.getUsername(),
//                user.getEmail(),
//                user.getPassword(),
//                user.getCreatedAt(),
//                user.getRole()
//        );
//        users.add(userToCreate);
//        System.out.println(userToCreate.getId());
//        System.out.println(userToCreate.getUsername());
//        System.out.println(userToCreate.getEmail());
//        System.out.println(userToCreate.getPassword());
//        System.out.println(userToCreate.getCreatedAt());
//        System.out.println(userToCreate.getRole());
//
//    }

    @PutMapping("{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user) {
        System.out.println("Updated user with id: " + id + ".");
        System.out.println(user);
    }

    @PutMapping("{id}/updatePassword")
    private void updatePassword(@PathVariable Long id, @RequestParam(required = false) String oldPassword, @Valid @Size(min = 3) @RequestParam String newPassword) {
        System.out.println("Updated user with id: " + id + ".");
        User newpass = getById(id);
        newpass.setPassword(newPassword);
        System.out.println(newpass);
    }

    @PutMapping("/username/{username}")
    public void updateUsername(@PathVariable String username, @RequestBody User user) {
        System.out.println("Updated user with username: " + username + ".");
        System.out.println(user);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id) {
        System.out.println("Deleted user with id: " + id);
        userService.deleteUserById(id);
    }
}




