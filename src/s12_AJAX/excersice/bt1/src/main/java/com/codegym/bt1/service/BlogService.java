package com.codegym.bt1.service;


import com.codegym.bt1.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    void save(Blog blog);
    void deleteById(Integer id);
    Blog findById (Integer id);
    List<Blog> searchByName(String name, int offset);
}
