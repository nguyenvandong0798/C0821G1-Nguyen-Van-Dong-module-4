package com.codegym.casestudy.service.service.impl;

import com.codegym.casestudy.model.service.Service;
import com.codegym.casestudy.repository.service.IServiceRepository;
import com.codegym.casestudy.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
@org.springframework.stereotype.Service("serviceService")
public class ServiceService implements IServiceService {
    @Autowired
    private IServiceRepository iServiceRepository;
    @Override
    public List<Service> getAll() {
        return null;
    }

    @Override
    public List<Service> findByName(String name) {
        return null;
    }

    @Override
    public Service findById(Integer id) {
        return null;
    }

    @Override
    public void save(Service service) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Page<Service> finAll(PageRequest of) {
        return null;
    }
}
