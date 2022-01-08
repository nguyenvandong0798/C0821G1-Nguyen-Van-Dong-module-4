package com.codegym.casestudy.repository.customer;

import com.codegym.casestudy.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from khach_hang where ho_ten like :name",nativeQuery = true)
    List<Customer> getByName(@Param("name") String name);
}
