package com.codegym.casestudy.service.customer.impl;

import com.codegym.casestudy.model.customer.Customer;
import com.codegym.casestudy.repository.customer.ICustomerRepository;
import com.codegym.casestudy.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("customerservice")
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Override
    public List<Customer> getAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public List<Customer> findByName(String name) {
        return iCustomerRepository.getByName("%"+name+"%");
    }

    @Override
    public Customer findById(Integer id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void remove(Integer id) {
        Customer customer = iCustomerRepository.getById(id);
        iCustomerRepository.delete(customer);
    }

    @Override
    public Page<Customer> finAll(PageRequest of) {
        return iCustomerRepository.findAll(of);
    }
}
