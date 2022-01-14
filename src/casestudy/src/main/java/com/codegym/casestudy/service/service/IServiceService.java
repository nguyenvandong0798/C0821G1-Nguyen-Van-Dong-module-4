package com.codegym.casestudy.service.service;

import com.codegym.casestudy.model.customer.Customer;
import com.codegym.casestudy.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IServiceService {
    List<Service> getAll();
    List<Service> findByName(String name);
    Service findById(Integer id);
    void save(Service service);
    void remove(Integer id);
    Page<Service> finAll(PageRequest of);
}
