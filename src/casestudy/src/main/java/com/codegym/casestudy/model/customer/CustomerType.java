package com.codegym.casestudy.model.customer;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "loai_khach")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ma_loai_khach")
    private Integer id;
    @Column(name = "ten_loai_khach")
    private String name;

    @OneToMany(mappedBy = "customerType")
    private Set<Customer> customers;

    public CustomerType(Integer id, String name, Set<Customer> customers) {
        this.id = id;
        this.name = name;
        this.customers = customers;
    }

    public CustomerType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
