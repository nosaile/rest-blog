package com.example.restblog.Services;

import com.example.restblog.data.Post;
import com.example.restblog.data.PostsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PostService {


    private final PostsRepository postsRepository;


    public PostService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }


    //works
    public List<Post> getAllPosts() {
        return postsRepository.findAll();
    }

    //works
    public Post getPostById(long id) {
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
    public void deletePostById(long id) {
        postsRepository.deleteById(id);
    }

    //works
    public List<Post> getPostsByTitleKeyword(String keyword) {
        return postsRepository.searchByTitleLike(keyword);
    }
}
