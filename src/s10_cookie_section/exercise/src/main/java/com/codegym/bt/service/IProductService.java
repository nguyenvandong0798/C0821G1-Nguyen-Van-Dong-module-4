package com.codegym.bt.service;

import com.codegym.bt.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
    Product getById(Long id);
    void remove(Long id);
    List<Product> findAllL();
}
