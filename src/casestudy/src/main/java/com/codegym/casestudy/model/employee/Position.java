package com.codegym.casestudy.model.employee;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "vi_tri")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_vi_tri")
    private Integer idPosition;
    @Column(name = "ten_vi_tri")
    private String namePosition;

    @OneToMany(mappedBy = "position")
    Set<Employee> employees;

    public Position() {
    }

    public Position(Integer idPosition, String namePosition, Set<Employee> employees) {
        this.idPosition = idPosition;
        this.namePosition = namePosition;
        this.employees = employees;
    }

    public Integer getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(Integer idPosition) {
        this.idPosition = idPosition;
    }

    public String getNamePosition() {
        return namePosition;
    }

    public void setNamePosition(String namePosition) {
        this.namePosition = namePosition;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
