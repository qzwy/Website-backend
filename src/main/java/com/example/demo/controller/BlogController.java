package com.example.demo.controller;

import com.example.demo.domain.Blog;
import com.example.demo.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/blog")
public class BlogController implements Serializable {
    private static final long serialVersionUID = 5348699681231849643L;

    @Autowired
    private BlogRepository blogRepository;

    @PostMapping("/save")
    public ResponseEntity<?> savaBlog(@RequestBody Map map){
        Blog save = new Blog();
        save.setCrtTime(new Date());
        save.setDescription(map.get("description").toString());
        save.setDetails(map.get("content").toString());
        save.setName(map.get("title").toString());
        save.setUserId(1l);
        blogRepository.save(save);
        System.out.println(save);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/all")
    public ResponseEntity<?> allBlogs(){
        List<Blog> blogs = blogRepository.findAll();
        return ResponseEntity.ok(blogs);
    }
}
