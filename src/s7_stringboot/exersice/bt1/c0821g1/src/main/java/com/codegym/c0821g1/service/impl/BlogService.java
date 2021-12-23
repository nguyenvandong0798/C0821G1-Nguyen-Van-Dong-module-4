package com.codegym.c0821g1.service.impl;

import com.codegym.c0821g1.model.Blog;
import com.codegym.c0821g1.repository.IBlogRepository;
import com.codegym.c0821g1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "blogService")
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;
    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }
    public List<Blog> getAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        Blog blog = iBlogRepository.getById(id);
        iBlogRepository.delete(blog);
    }

}
