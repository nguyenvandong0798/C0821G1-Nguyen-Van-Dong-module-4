package com.codegym.casestudy.model.service;

import com.codegym.casestudy.model.contract.Contract;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "dich_vu")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_dich_vu")
    private Integer id;
    @Column(name = "ten_dich_vu")
    private String name;
    @Column(name = "dien_tich")
    private Integer area;
    @Column(name = "chi_phi_thue")
    private Double rent;
    @Column(name = "so_nguoi_toi_da")
    private Integer numberPeople;
    @Column(name = "tieu_chuan_phong")
    private String standard;
    @Column(name = "mo_ta_tien_nghi_khac")
    private String status;
    @Column(name = "dien_tich_ho_boi")
    private Double areaPool;
    @Column(name = "so_tang")
    private Integer numberPloor;

    @ManyToOne
    @JoinColumn(name = "ma_kieu_thue")
    private RantType rantType;

    @ManyToOne
    @JoinColumn(name = "ma_loai_dich_vu")
    private ServiceType serviceType;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private Set<Contract> contracts;

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public Service() {
    }

    public Service(Integer id, String name, Integer area, double rent, Integer numberPeople, String standard,
                   String status, Double areaPool, Integer numberPloor, RantType rantType, ServiceType serviceType) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.rent = rent;
        this.numberPeople = numberPeople;
        this.standard = standard;
        this.status = status;
        this.areaPool = areaPool;
        this.numberPloor = numberPloor;
        this.rantType = rantType;
        this.serviceType = serviceType;
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

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getRent() {
        return rent;
    }

    public void setRent(Double rent) {
        this.rent = rent;
    }

    public Integer getNumberPeople() {
        return numberPeople;
    }

    public void setNumberPeople(Integer numberPeople) {
        this.numberPeople = numberPeople;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(Double areaPool) {
        this.areaPool = areaPool;
    }

    public Integer getNumberPloor() {
        return numberPloor;
    }

    public void setNumberPloor(Integer numberPloor) {
        this.numberPloor = numberPloor;
    }

    public RantType getRantType() {
        return rantType;
    }

    public void setRantType(RantType rantType) {
        this.rantType = rantType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
