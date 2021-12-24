package com.codegym.c0821g1.service.impl;

import com.codegym.c0821g1.model.Blog;
import com.codegym.c0821g1.model.Category;
import com.codegym.c0821g1.repository.ICategoryRepository;
import com.codegym.c0821g1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "categoryService")
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> getAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return iCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public void remove(int id) {
        Category category = iCategoryRepository.getById(id);
        iCategoryRepository.delete(category);
    }

    @Override
    public Page<Category> findAll(PageRequest of) {
        return iCategoryRepository.findAll(of);
    }

    @Override
    public List<Category> findByName(String name) {
        return iCategoryRepository.getByName("%"+name+"%");
    }
}