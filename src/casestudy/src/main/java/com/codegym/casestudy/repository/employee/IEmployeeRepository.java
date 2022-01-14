package com.codegym.casestudy.repository.employee;
import com.codegym.casestudy.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "select * from nhan_vien where ho_va_ten like :name",nativeQuery = true)
    List<Employee> getByName(@Param("name") String name);
}
