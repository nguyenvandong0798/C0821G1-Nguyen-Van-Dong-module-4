package com.codegym.bt.repository;

import com.codegym.bt.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "iBookRepository")
public interface IBookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "select * from book where name like :name",nativeQuery = true)
    List<Book> getByName(@Param("name") String name);
}
