package com.codegym.casestudy.service.employee.impl;

import com.codegym.casestudy.model.employee.Position;
import com.codegym.casestudy.repository.employee.IPositionRepository;
import com.codegym.casestudy.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("positionService")
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository iPositionRepository;
    @Override
    public List<Position> getAll() {
        return iPositionRepository.findAll();
    }

    @Override
    public List<Position> search(String name) {
        return null;
    }

    @Override
    public void save(Position position) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Position findById(Integer id) {
        return null;
    }

    @Override
    public Page<Position> finAll(PageRequest of) {
        return null;
    }
}
