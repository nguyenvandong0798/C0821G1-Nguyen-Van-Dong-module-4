package com.codegym.casestudy.service.employee.impl;

import com.codegym.casestudy.model.employee.Skill;
import com.codegym.casestudy.repository.employee.ISkillRepository;
import com.codegym.casestudy.service.employee.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("SkillService")
public class SkillService implements ISkillService {
    @Autowired
    private ISkillRepository iSkillRepository;
    @Override
    public List<Skill> getAll() {
        return iSkillRepository.findAll();
    }

    @Override
    public List<Skill> search(String name) {
        return null;
    }

    @Override
    public void save(Skill skill) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Skill findById(Integer id) {
        return null;
    }

    @Override
    public Page<Skill> finAll(PageRequest of) {
        return null;
    }
}
