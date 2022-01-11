package com.codegym.casestudy.service.employee;


import com.codegym.casestudy.model.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IPositionService {
    List<Position> getAll();
    List<Position> search(String name);
    void save(Position position);
    void remove(Integer id);
    Position findById(Integer id);
    Page<Position> finAll(PageRequest of);
}
