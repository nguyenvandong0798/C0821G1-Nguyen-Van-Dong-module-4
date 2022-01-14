package com.codegym.casestudy.repository.contract;

import com.codegym.casestudy.model.contract.Contract;
import com.codegym.casestudy.model.contract.ContractDetail;
import com.codegym.casestudy.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "select * from hop_dong where ho_ten like :name",nativeQuery = true)
    List<Contract> getByName(@Param("name") String name);
}
