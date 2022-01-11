package com.codegym.casestudy.model.employee;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "trinh_do")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_trinh_do")
    private Integer idSkill;
    @Column(name = "ten_trinh_do")
    private String nameSkill;

    @OneToMany(mappedBy = "skill")
    Set<Employee> employees;

    public Skill() {
    }

    public Skill(Integer id, String nameSkill, Set<Employee> employees) {
        this.idSkill = id;
        this.nameSkill = nameSkill;
        this.employees = employees;
    }

    public Integer getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(Integer id) {
        this.idSkill = id;
    }

    public String getNameSkill() {
        return nameSkill;
    }

    public void setNameSkill(String nameSkill) {
        this.nameSkill = nameSkill;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
