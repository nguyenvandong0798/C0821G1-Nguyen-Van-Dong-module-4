package com.codegym.bt.service.impl;


import com.codegym.bt.model.Code;
import com.codegym.bt.repository.ICodeRepository;
import com.codegym.bt.service.ICodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "codeService")
public class CodeService implements ICodeService {
    @Autowired
    private ICodeRepository iCodeRepository;

    @Override
    public List<Code> getAll() {
        return iCodeRepository.findAll();
    }

    @Override
    public List<Code> findAll() {
        return iCodeRepository.findAll();
    }

    @Override
    public List<Code> findByCode(Integer code) {
//        return iCodeRepository.getByCode("%"+code+"%");
        return null;
    }

    @Override
    public Code findById(Integer id) {
        return iCodeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Code code) {
        iCodeRepository.save(code);
    }

    @Override
    public void remove(int id) {
       Code  code = iCodeRepository.getById(id);
        iCodeRepository.delete(code);
    }
}
