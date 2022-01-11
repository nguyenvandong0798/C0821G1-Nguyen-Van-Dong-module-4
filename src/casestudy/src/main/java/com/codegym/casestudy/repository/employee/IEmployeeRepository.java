package com.codegym.casestudy.repository.employee;

import com.codegym.casestudy.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
}
