package com.codegym.casestudy.model.employee;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "bo_phan")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_bo_phan")
    private Integer idDepartment;
    @Column(name = "ten_bo_phan")
    private String nameDepartment;

    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;

    public Department() {
    }

    public Department(Integer idDepartment, String nameDepartment, Set<Employee> employees) {
        this.idDepartment = idDepartment;
        this.nameDepartment = nameDepartment;
        this.employees = employees;
    }

    public Integer getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(Integer idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
