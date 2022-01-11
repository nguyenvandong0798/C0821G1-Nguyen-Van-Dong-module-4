package com.codegym.casestudy.service.employee;

import com.codegym.casestudy.model.employee.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ISkillService {
    List<Skill> getAll();
    List<Skill> search(String name);
    void save(Skill skill);
    void remove(Integer id);
    Skill findById(Integer id);
    Page<Skill> finAll(PageRequest of);}
