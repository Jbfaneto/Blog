package com.blog.mongo.resources;

import com.blog.mongo.domain.Post;
import com.blog.mongo.dto.PostDTO;
import com.blog.mongo.resources.util.URL;
import com.blog.mongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue = "") String text) {
        text = URL.decodeParam(text); // decodes the text parameter (if it has any special characters)
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value="text", defaultValue = "") String text,
            @RequestParam(value="minDate", defaultValue = "") String minDate,
            @RequestParam(value="maxDate", defaultValue = "") String maxDate) {
        text = URL.decodeParam(text); // decodes the text parameter (if it has any special characters)
        List<Post> list = service.fullSearch(text, URL.convertDate(minDate, new Date(0L)), URL.convertDate(maxDate, new Date()));
        return ResponseEntity.ok().body(list);
    }


}
