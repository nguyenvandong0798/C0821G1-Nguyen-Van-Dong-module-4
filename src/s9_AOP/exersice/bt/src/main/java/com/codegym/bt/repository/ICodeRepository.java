package com.codegym.bt.repository;

import com.codegym.bt.model.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository(value = "iCodeRepository")
public interface ICodeRepository extends JpaRepository<Code, Integer> {

//        @Query(value = "select * from code where code like :code",nativeQuery = true)
//        List<Code> getByCode(@Param("name") Integer code);
}
