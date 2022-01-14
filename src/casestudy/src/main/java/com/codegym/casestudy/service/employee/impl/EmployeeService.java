package com.codegym.casestudy.service.employee.impl;

import com.codegym.casestudy.model.employee.Employee;
import com.codegym.casestudy.repository.employee.IEmployeeRepository;
import com.codegym.casestudy.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("employeeService")
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;
    @Override
    public List<Employee> getAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public List<Employee> searchByName(String name) {
        return iEmployeeRepository.getByName("%"+name+"%");
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public void remove(Integer id) {
        Employee employee= iEmployeeRepository.getById(id);
        iEmployeeRepository.delete(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return iEmployeeRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Employee> finAll(PageRequest of) {
        return iEmployeeRepository.findAll(of);
    }
}
