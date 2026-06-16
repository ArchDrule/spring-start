package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PostsIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostRepository postRepository;

    @Test
    void createPost_savesPostAndRedirectsToList() throws Exception {
        long countBefore = postRepository.count();

        mockMvc.perform(post("/new")
                        .param("text", "Тестовый пост"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));

        long countAfter = postRepository.count();
        org.junit.jupiter.api.Assertions.assertEquals(countBefore + 1, countAfter);
    }

    @Test
    void likePost_incrementsLikesCountInDatabase() throws Exception {
        Post post = postRepository.save(new Post(null, "Пост для лайка", new Date()));

        mockMvc.perform(post("/post/" + post.getId() + "/like"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));

        mockMvc.perform(post("/post/" + post.getId() + "/like"))
                .andExpect(status().isOk())
                .andExpect(content().string("2"));

        Post updated = postRepository.findById(post.getId()).get();
        org.junit.jupiter.api.Assertions.assertEquals(2, updated.getLikes());
    }
}