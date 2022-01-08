package com.codegym.casestudy.service.customer;

import com.codegym.casestudy.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> getAll();
    List<CustomerType> findByName(String name);
    CustomerType findById(Integer id);
    void save(CustomerType customerType);
    void remove(Integer id);
    Page<CustomerType> finAll(PageRequest of);
}
