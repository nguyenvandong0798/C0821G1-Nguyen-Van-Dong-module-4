package com.codegym.bt.controller;


import com.codegym.bt.model.Blog;
import com.codegym.bt.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    @Qualifier("IBlogService")
    private IBlogService iBlogService;

    @GetMapping
    public ResponseEntity<List<Blog>> findAllBlog() {
        List<Blog> blogs =iBlogService.getAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable Integer id) {
        Blog  blog = iBlogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iBlogService.save(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Integer id, @RequestBody Blog blog) {
        Blog blog1 = iBlogService.findById(id);
        if (blog1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setId(blog1.getId());
        iBlogService.save(blog);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable Integer id) {
        Blog blog = iBlogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iBlogService.remove(id);
        return new ResponseEntity<>(blog,HttpStatus.NO_CONTENT);
    }

}