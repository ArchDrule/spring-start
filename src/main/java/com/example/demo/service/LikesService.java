package com.example.demo.service;

import com.example.demo.model.Post;
import org.springframework.stereotype.Service;

@Service
public class LikesService {
    PostService postService;

    public LikesService() {
        postService = new PostService();
    }

    public int like(Long postId) {
        Post post = postService.listAllPosts().get(postId.intValue());
        post.setLikes(post.getLikes() + 1);
        return post.getLikes();
    }
}
