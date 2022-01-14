package com.codegym.casestudy.service.employee;

import com.codegym.casestudy.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAll();

    List<Employee> searchByName(String name);

    void save(Employee employee);

    void remove(Integer id);

    Employee findById(Integer id);

    Page<Employee> finAll(PageRequest of);
}
