package com.codegym.service;

import com.codegym.model.Product;
import sun.dc.pr.PRError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static final Map<Integer, Product> produces;

    static {

        produces = new HashMap<>();
        produces.put(1, new Product(1, "John", "1000", "drink","VN"));
        produces.put(2, new Product(2, "Bob", "2000", "drink","VN"));
        produces.put(3, new Product(3, "jen", "3000", "food","VN"));
        produces.put(4, new Product(4, "ba", "4000", "food","VN"));
        produces.put(5, new Product(5, "Dong", "5000", "drink","VN"));
        produces.put(6, new Product(6, "han", "6000", "food","VN"));
        produces.put(7, new Product(7, "ken", "7000", "food","VN"));

    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(produces.values());
    }

    @Override
    public void save(Product product) {
        produces.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return produces.get(id);
    }

    @Override
    public void update(int id, Product produce) {
        produces.put(id, produce);

    }

    @Override
    public void remove(int id) {
        produces.remove(id);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> products =new ArrayList<>();
        for (Map.Entry<Integer, Product> entry : produces.entrySet()) {
            if (entry.getValue().getName().equals(name)){
                products.add(entry.getValue());
            }
        }
        return products;
    }
}
