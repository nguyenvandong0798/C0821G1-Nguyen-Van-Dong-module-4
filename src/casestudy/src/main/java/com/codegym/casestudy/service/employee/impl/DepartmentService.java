package com.codegym.casestudy.service.employee.impl;

import com.codegym.casestudy.model.employee.Department;
import com.codegym.casestudy.repository.employee.IDepartmentRepository;
import com.codegym.casestudy.service.employee.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("departmentService")
public class DepartmentService implements IDepartmentService {
    @Autowired
    private IDepartmentRepository iDepartmentRepository;
    @Override
    public List<Department> getAll() {
        return iDepartmentRepository.findAll();
    }

    @Override
    public List<Department> search(String name) {
        return null;
    }

    @Override
    public Department findById(Integer id) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public void save(Department department) {

    }

    @Override
    public Page<Department> findAll(PageRequest of) {
        return null;
    }
}
