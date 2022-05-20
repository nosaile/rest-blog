package com.example.restblog.Services;

import com.example.restblog.data.Post;
import com.example.restblog.data.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final List<User> userList = setUserList();
    private final List<Post> posts = setPostList();

    public List<User> getUserList() {
        return userList;
    }

    public List<Post> getPostList() {
        return posts;
    }


    public void addPost(Post newPost, String username) {
        User user = getUserByUsername(username);
        user.getPosts().add(newPost);
        newPost.setUser(user);
        posts.add(newPost);
    }

    public User getUserById(Long id) {
        for (User user : userList) {
            if (user.getId() == (id)) {
                return user;
            }
        }
        return null;
    }

    public User getUserByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        return null;
    }

    public User getUserByEmail(String email) {
        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public List<User> setUserList() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1L, "nosaile", "1email@web.com", "pass1"));
        userList.add(new User(2L, "sirhc", "2email@web.com", "pass2"));
        userList.add(new User(3L, "topherson", "3email@web.com", "pass3"));
        userList.add(new User(4L, "player1", "4email@web.com", "pass4"));
        userList.add(new User(5L, "player2", "5email@web.com", "pass5"));
        userList.add(new User(6L, "player3", "6email@web.com", "pass6"));

        return userList;
    }

    private List<Post> setPostList() {
        List<Post> postList = new ArrayList<>();
        postList.add(new Post(1L, "posty post", "im the content for posty post"));
        postList.add(new Post(2L, "spicy", "the spicy post"));
        postList.add(new Post(3L, "post3", "im the 3rd post"));
        postList.add(new Post(4L, "Title", "Content"));
        postList.add(new Post(5L, "Generic", "generic content in here"));
        postList.add(new Post(6L, "New Posting", "im brand a new post look at me"));
        postList.add(new Post(7L, "post7", "im the 7th post"));
        postList.add(new Post(8L, "Testing", "im a test post"));

        return postList;
    }

}
