package com.codegym.casestudy.repository.employee;

import com.codegym.casestudy.model.employee.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
}
