package com.codegym.bt1.service.impl;


import com.codegym.bt1.model.Blog;
import com.codegym.bt1.repository.BlogRepository;
import com.codegym.bt1.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void deleteById(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> searchByName(String name, int offset) {
        return blogRepository.searchName(name, offset);
    }

}
