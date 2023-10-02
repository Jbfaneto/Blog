package com.blog.mongo.dto;

import java.io.Serializable;

public class PostDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private String id;
    private String title;

    public PostDTO(){

    }

    public PostDTO(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public PostDTO(PostDTO postDTO) {
        this.id = postDTO.getId();
        this.title = postDTO.getTitle();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
