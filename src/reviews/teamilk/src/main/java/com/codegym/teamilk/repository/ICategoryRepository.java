package com.codegym.teamilk.repository;

import com.codegym.teamilk.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value="iCategoryRepository")
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
