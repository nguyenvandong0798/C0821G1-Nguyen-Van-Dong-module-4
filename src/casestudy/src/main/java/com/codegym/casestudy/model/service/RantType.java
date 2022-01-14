package com.codegym.casestudy.model.service;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "kieu_thue")
public class RantType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_kieu_thue")
    private Integer id;
    @Column(name = "ten_kieu_thue")
    private String name;
    @Column(name = "gia_thue")
    private Double price;

   @OneToMany(mappedBy = "rantType", cascade = CascadeType.ALL)
    private Set<Service> services;

    public RantType() {
    }

    public RantType(Integer id, String name, Double price, Set<Service> services) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.services = services;
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

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }
}
