package com.codegym.casestudy.service.contract;

import com.codegym.casestudy.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IContractService {
    List<Contract> getAll();
    List<Contract> findByName(String name);
    Contract findById(Integer id);
    void save(Contract contract);
    void remove(Integer id);
    Page<Contract> finAll(PageRequest of);
}
