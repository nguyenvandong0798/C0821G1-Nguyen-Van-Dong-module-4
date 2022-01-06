package com.codegym.bt1.repository;

import com.codegym.bt1.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "SELECT * FROM blog WHERE blog.name LIKE concat('%', ?1, '%') LIMIT ?2 , 2;", nativeQuery=true)
    List<Blog> searchName(String name, int offset);
}
