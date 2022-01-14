package com.codegym.casestudy.model.service;

import com.codegym.casestudy.model.contract.ContractDetail;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "dich_vu_di_kem")
public class ServiceMore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_dich_vu_di_kem")
    private Integer id;
    @Column(name = "ten_dich_vu_di_kem")
    private String name;
    @Column(name = "gia")
    private Double price;
    @Column(name = "don_vi")
    private String unit;
    @Column(name = "trang_thai")
    private String status;

    @OneToMany(mappedBy = "serviceMore", cascade = CascadeType.ALL)
    private Set<ContractDetail> contractDetails;

    public ServiceMore() {
    }

    public ServiceMore(Integer id, String name, Double price, String unit, String status, Set<ContractDetail> contractDetails) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.status = status;
        this.contractDetails = contractDetails;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
