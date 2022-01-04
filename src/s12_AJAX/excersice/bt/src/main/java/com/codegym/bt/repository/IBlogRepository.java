package com.codegym.bt.repository;


import com.codegym.bt.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "iBlogRepository")
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
  @Query(value = "select * from blog where title like :title",nativeQuery = true)
    List<Blog> getByName(@Param("title")String title);

}