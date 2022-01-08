package com.codegym.casestudy.service.customer;

import com.codegym.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAll();
    List<Customer> findByName(String name);
    Customer findById(Integer id);
    void save(Customer customer);
    void remove(Integer id);
    Page<Customer> finAll(PageRequest of);
}
