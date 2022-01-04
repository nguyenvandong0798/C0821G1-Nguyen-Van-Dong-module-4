package com.codegym.teamilk.service;

import com.codegym.teamilk.model.Tea;

import java.util.List;

public interface ITeaService {
    List<Tea> getAll();
    Tea findById(Integer id);
    void save(Tea teaMilk);
    void remove(Integer id);
    List<Tea> findByName(String name);
}
