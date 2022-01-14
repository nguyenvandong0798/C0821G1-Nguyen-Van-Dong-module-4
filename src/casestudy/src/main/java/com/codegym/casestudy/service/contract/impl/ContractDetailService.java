package com.codegym.casestudy.service.contract.impl;

import com.codegym.casestudy.model.contract.ContractDetail;
import com.codegym.casestudy.repository.contract.IContractDetailRepository;
import com.codegym.casestudy.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("contractDetailService")
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository iContractDetailRepository;
    @Override
    public List<ContractDetail> getAll() {
        return iContractDetailRepository.findAll();
    }

    @Override
    public List<ContractDetail> findByName(String name) {
        return null;
    }

    @Override
    public ContractDetail findById(Integer id) {
        return iContractDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        iContractDetailRepository.save(contractDetail);
    }

    @Override
    public void remove(Integer id) {
        ContractDetail contractDetail = iContractDetailRepository.getById(id);
        iContractDetailRepository.delete(contractDetail);
    }

    @Override
    public Page<ContractDetail> finAll(PageRequest of) {
        return iContractDetailRepository.findAll(of);
    }
}
