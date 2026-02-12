package com.example.demo.service;

import com.example.demo.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {
    private final ArrayList<Post> posts;

    public PostService() {
        this.posts = new ArrayList<Post>();

        posts.add(new Post(0L, "Перед бурей", new Date()));
        posts.add(new Post(1L, "Старшая эда", new Date()));
        posts.add(new Post(2L, "Владыки реальности", new Date()));
    }

    public ArrayList<Post> listAllPosts() {
        return posts;
    }

    public void create(String text) {
        posts.add(new Post((long) posts.size(), text, new Date()));
    }
}
