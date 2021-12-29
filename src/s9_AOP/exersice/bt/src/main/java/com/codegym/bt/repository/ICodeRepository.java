package com.codegym.bt.repository;

import com.codegym.bt.model.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "iCodeRepository")
public interface ICodeRepository extends JpaRepository<Code, Integer> {
}
