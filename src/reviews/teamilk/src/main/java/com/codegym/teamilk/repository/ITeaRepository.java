package com.codegym.teamilk.repository;

import com.codegym.teamilk.model.Category;
import com.codegym.teamilk.model.Tea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "iTeaRepository")
public interface ITeaRepository extends JpaRepository<Tea, Integer> {
}
