package com.codegym.c0821g1.repository;

import com.codegym.c0821g1.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "iCategoryRepository")
public interface ICategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "select * from category where name like :name",nativeQuery = true)
    List<Category> getByName(@Param("name") String name);
}
