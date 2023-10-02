package com.blog.mongo.resources;

import com.blog.mongo.domain.Post;
import com.blog.mongo.dto.PostDTO;
import com.blog.mongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable String id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(new PostDTO(obj.getId(), obj.getTitle()));
    }

}
