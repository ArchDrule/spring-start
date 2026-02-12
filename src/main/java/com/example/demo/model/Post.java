package com.example.demo.model;

import javax.xml.crypto.Data;
import java.util.Date;

public class Post {
    private Long id;
    private String text;
    private Integer likes;
    private Date creationDate;

    public Post(Long id, String text, Date date) {
        this.id = id;
        this.text = text;
        this.likes = 0;
        this.creationDate = date;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer num) {
        likes = num;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}
