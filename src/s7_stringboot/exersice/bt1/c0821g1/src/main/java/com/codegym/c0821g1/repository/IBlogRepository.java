package com.codegym.c0821g1.repository;

import com.codegym.c0821g1.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IBlogRepository extends JpaRepository<Blog, Integer> {

}
