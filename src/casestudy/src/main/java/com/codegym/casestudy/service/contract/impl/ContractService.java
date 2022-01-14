package com.codegym.casestudy.service.contract.impl;

import com.codegym.casestudy.model.contract.Contract;
import com.codegym.casestudy.model.customer.Customer;
import com.codegym.casestudy.repository.contract.IContractRepository;
import com.codegym.casestudy.repository.customer.ICustomerRepository;
import com.codegym.casestudy.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("contractService")
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;
    @Override
    public List<Contract> getAll() {
        return iContractRepository.findAll();
    }

    @Override
    public List<Contract> findByName(String name) {
        return iContractRepository.getByName("%"+name+"%");
    }

    @Override
    public Contract findById(Integer id) {
        return iContractRepository.findById(id).orElse(null);

    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);

    }

    @Override
    public void remove(Integer id) {
        Contract contract = iContractRepository.getById(id);
        iContractRepository.delete(contract);
    }

    @Override
    public Page<Contract> finAll(PageRequest of) {
        return iContractRepository.findAll(of);
    }
}
