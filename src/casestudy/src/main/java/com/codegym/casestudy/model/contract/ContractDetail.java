package com.codegym.casestudy.model.contract;

import com.codegym.casestudy.model.service.ServiceMore;

import javax.persistence.*;

@Entity(name = "hop_dong_chi_tiet")
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_hop_dong_chi_tiet")
    private Integer id;
    @Column(name = "so_luong")
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "ma_hop_dong")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "ma_dich_vu_di_kem")
    private ServiceMore serviceMore;

    public ContractDetail() {
    }

    public ContractDetail(Integer id, Integer amount, Contract contract, ServiceMore serviceMore) {
        this.id = id;
        this.amount = amount;
        this.contract = contract;
        this.serviceMore = serviceMore;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public ServiceMore getServiceMore() {
        return serviceMore;
    }

    public void setServiceMore(ServiceMore serviceMore) {
        this.serviceMore = serviceMore;
    }
}
