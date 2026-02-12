package com.example.demo.service;

import com.example.demo.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {
    public ArrayList<Post> listAllPosts() {
        ArrayList<Post> list = new ArrayList<Post>();
        list.add(new Post("Перед бурей", new Date()));
        list.add(new Post("Старшая эда", new Date()));
        list.add(new Post("Владыки реальности", new Date()));

        return list;
    }
}
