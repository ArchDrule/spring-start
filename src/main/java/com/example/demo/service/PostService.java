package com.example.demo.service;

import com.example.demo.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PostService {
    public ArrayList<Post> listAllPosts() {
        ArrayList<Post> list = new ArrayList<Post>();
        list.add(new Post("Перед бурей"));
        list.add(new Post("Старшая эда"));
        list.add(new Post("Владыки реальности"));

        return list;
    }
}
