package com.codegym.casestudy.repository.employee;

import com.codegym.casestudy.model.employee.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISkillRepository extends JpaRepository<Skill, Integer> {
}
