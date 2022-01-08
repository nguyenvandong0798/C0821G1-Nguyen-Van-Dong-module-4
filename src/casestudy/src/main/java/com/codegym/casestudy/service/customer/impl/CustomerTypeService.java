package com.codegym.casestudy.service.customer.impl;

import com.codegym.casestudy.model.customer.CustomerType;
import com.codegym.casestudy.repository.customer.ICustomerRepository;
import com.codegym.casestudy.repository.customer.ICustomerTypeRepository;
import com.codegym.casestudy.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("customertypeservice")
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;
    @Override
    public List<CustomerType> getAll() {
        return iCustomerTypeRepository.findAll();
    }

    @Override
    public List<CustomerType> findByName(String name) {
        return null;
    }

    @Override
    public CustomerType findById(Integer id) {
        return null;
    }

    @Override
    public void save(CustomerType customerType) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Page<CustomerType> finAll(PageRequest of) {
        return null;
    }
}
