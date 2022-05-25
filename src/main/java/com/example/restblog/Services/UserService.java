package com.example.restblog.Services;


import com.example.restblog.data.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
//works
    public List<Post> getAllPosts() {
        return postsRepository.findAll();
    }
//works if you manually input a password field on swagger, not sure why yet
    public void addUser(User newUser){
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
    public User getUserByEmail(String email){
        return usersRepository.findByEmail(email);
    }
//works
    public Post getPostById(long id){
        for (Post post : postsRepository.findAll()) {
            if (Objects.equals(post.getId(), id)) {
                return post;
            }
        }
       return postsRepository.getById(id);
    }
//works
    public void updatePost(long postId, Post post) {
        Post postToUpdate = postsRepository.findById(postId).orElseThrow();
        if (post.getContent() != null && !post.getContent().isEmpty()) {
            postToUpdate.setContent(post.getContent());
        }
        if (post.getTitle() != null && !post.getTitle().isEmpty()) {
            postToUpdate.setTitle(post.getTitle());
        }

        postsRepository.save(postToUpdate);
    }
//works
    public void updateUserPassword(long id, String newPassword){
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

    public void updateEmail(long id, String email){
        User setNewEmail = usersRepository.findById(id);
        setNewEmail.setEmail(email);
        usersRepository.save(setNewEmail);
    }
//works
    public void deletePostById(long id) {
        // TODO: change old code to postsRepository.deleteById(id)
        postsRepository.deleteById(id);
    }
//works
    public List<Post> getPostsByTitleKeyword(String keyword) {
        return postsRepository.searchByTitleLike(keyword);
    }

}

