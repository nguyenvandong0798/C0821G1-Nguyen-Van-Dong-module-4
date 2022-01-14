package com.codegym.casestudy.service.contract;

import com.codegym.casestudy.model.contract.Contract;
import com.codegym.casestudy.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> getAll();
    List<ContractDetail> findByName(String name);
    ContractDetail findById(Integer id);
    void save(ContractDetail contractDetail);
    void remove(Integer id);
    Page<ContractDetail> finAll(PageRequest of);
}
