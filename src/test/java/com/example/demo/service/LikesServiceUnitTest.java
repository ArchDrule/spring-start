package com.example.demo.service;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LikesServiceUnitTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private LikesService likesService;

    private Post post;

    @BeforeEach
    void setUp() {
        post = new Post(1L, "Тестовый текст", new Date());
        post.setLikes(0);
    }

    @Test
    void like_incrementsLikesByOneAndSavesPost() {
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(postRepository.save(any(Post.class))).thenReturn(post);

        int result = likesService.like(1L);

        assertEquals(1, result);
        assertEquals(1, post.getLikes());
        verify(postRepository, times(1)).findById(1L);
        verify(postRepository, times(1)).save(post);
    }

    @Test
    void like_throwsExceptionWhenPostNotFound() {
        when(postRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(java.util.NoSuchElementException.class, () -> likesService.like(99L));

        verify(postRepository, never()).save(any(Post.class));
    }
}