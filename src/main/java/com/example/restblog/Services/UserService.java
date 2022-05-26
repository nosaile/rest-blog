package com.example.restblog.Services;


import com.example.restblog.data.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UsersRepository usersRepository;
    private final PostsRepository postsRepository;
    private final CategoriesRepository categoriesRepository;

    public UserService(UsersRepository usersRepository, PostsRepository postsRepository, CategoriesRepository categoriesRepository) {
        this.usersRepository = usersRepository;
        this.postsRepository = postsRepository;
        this.categoriesRepository = categoriesRepository;
    }

    //works
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    //works if you manually input a password field on swagger, not sure why yet
    public void addUser(User newUser) {
        usersRepository.save(newUser);
    }

    //works
    public void addPost(Post newPost, String username) {
        User user = getUserByUsername(username);
        user.getPosts().add(newPost);
        newPost.setUser(user);
        List<Category> categoriesToAdd = new ArrayList<>();
        for (Category category : newPost.getCategories()) {
            categoriesToAdd.add(categoriesRepository.findCategoryByName(category.getName()));
        }
        newPost.setCategories(categoriesToAdd);
        postsRepository.save(newPost);
    }

    //works
    public User getUserById(Long id) {
        return usersRepository.findById(id).orElseThrow();
    }

    //works
    public User getUserByUsername(String username) {

        return usersRepository.findByUsername(username);
    }

    //works
    public User getUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }


    //works
    public void updateUserPassword(long id, String newPassword) {
        User setNewPass = usersRepository.findById(id);
        setNewPass.setPassword(newPassword);
        usersRepository.save(setNewPass);

    }

    //works
    public void updateUserName(long id, String newUserName) {
        User setUsername = usersRepository.findById(id);
        setUsername.setUsername(newUserName);
        usersRepository.save(setUsername);
    }

    public void updateEmail(long id, String email) {
        User setNewEmail = usersRepository.findById(id);
        setNewEmail.setEmail(email);
        usersRepository.save(setNewEmail);
    }

}

