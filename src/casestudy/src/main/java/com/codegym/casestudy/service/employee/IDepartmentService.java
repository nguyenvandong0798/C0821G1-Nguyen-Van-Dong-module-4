package com.codegym.casestudy.service.employee;

import com.codegym.casestudy.model.employee.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IDepartmentService {
    List<Department> getAll();
    List<Department> search(String name);
    Department findById(Integer id);
    void remove(Integer id);
    void save(Department department);
    Page<Department> findAll(PageRequest of);
}
