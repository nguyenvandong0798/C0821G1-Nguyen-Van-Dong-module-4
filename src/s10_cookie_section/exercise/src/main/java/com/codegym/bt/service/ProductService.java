package com.codegym.bt.service;

import com.codegym.bt.model.Product;
import com.codegym.bt.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
        Product product = productRepository.getById(id);
        productRepository.delete(product);
    }

    @Override
    public List<Product> findAllL() {
        return productRepository.findAll();
    }

}
