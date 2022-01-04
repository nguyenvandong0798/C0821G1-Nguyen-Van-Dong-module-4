package com.codegym.teamilk.service.impl;

import com.codegym.teamilk.model.Category;
import com.codegym.teamilk.model.Tea;
import com.codegym.teamilk.repository.ICategoryRepository;
import com.codegym.teamilk.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Category findById(Integer id) {
        return null;
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public List<Tea> findByName(String name) {
        return null;
    }
}
