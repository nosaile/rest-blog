package com.example.restblog.web;


import com.example.restblog.data.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {

    ArrayList<User> users = new ArrayList<>();
    User user1 = new User(1,"nosaile", "1email@web.com", "pass1", new Date(2005/10/10), User.Role.USER);
    User user2 = new User(2,"sirhc", "2email@web.com", "pass2", new Date(2019/11/3), User.Role.USER);
    User user3 = new User(3,"topherson", "3email@web.com", "pass3", new Date(2010/5/11), User.Role.USER);
    User user4 = new User(4,"player1", "4email@web.com", "pass4", new Date(2001/12/9), User.Role.ADMIN);
    User user5 = new User(5,"player2", "5email@web.com", "pass5", new Date(2003/6/7), User.Role.USER);

    @GetMapping
    public ArrayList<User> getAll() {
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        return users;
    }

}
