package com.codegym.bt.service;

import com.codegym.bt.model.Code;

import java.util.List;

public interface ICodeService {
    List<Code> getAll();

    List<Code> findAll();

    List<Code> findByCode(Integer code);

    Code findById(Integer id);

    void save(Code code);

    void remove(int id);
}
