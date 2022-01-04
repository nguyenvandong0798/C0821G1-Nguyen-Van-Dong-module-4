package com.codegym.teamilk.service;

import com.codegym.teamilk.model.Category;
import com.codegym.teamilk.model.Tea;

import java.util.List;

public interface ICategoryService {
    List<Category> getAll();
    Category findById(Integer id);
    void save(Category category);
    void remove(Integer id);
    List<Tea> findByName(String name);
}
