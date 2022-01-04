package com.codegym.bt.repository;

import com.codegym.bt.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "iCategoryRepository")
public interface ICategoryRepository extends JpaRepository<Category,Integer> {

    @Query(value = "select * from category where name like :name",nativeQuery = true)
    List<Category> findByName(@Param("name") String name);
}