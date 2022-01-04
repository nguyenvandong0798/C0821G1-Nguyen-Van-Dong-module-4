package com.codegym.teamilk.service.impl;

import com.codegym.teamilk.model.Tea;
import com.codegym.teamilk.repository.ITeaRepository;
import com.codegym.teamilk.service.ITeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "teaService")
public class TeaService implements ITeaService {
    @Autowired
    private ITeaRepository iTeaRepository;

    @Override
    public List<Tea> getAll() {
        return iTeaRepository.findAll();
    }

    @Override
    public Tea findById(Integer id) {
        return iTeaRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Tea teaMilk) {
        iTeaRepository.save(teaMilk);
    }

    @Override
    public void remove(Integer id) {
        Tea tea = iTeaRepository.getById(id);
        iTeaRepository.delete(tea);
    }

    @Override
    public List<Tea> findByName(String name) {
        return null;
    }
}
