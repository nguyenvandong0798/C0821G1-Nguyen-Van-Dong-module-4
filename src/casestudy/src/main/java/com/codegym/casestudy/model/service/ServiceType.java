package com.codegym.casestudy.model.service;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "loai_dich_vu")
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_loai_dich_vu")
    private Integer id;
    @Column(name = "ten_loai_dich_vu")
    private String name;

    @OneToMany(mappedBy = "serviceType", cascade = CascadeType.ALL)
    private Set<Service> services;

    public ServiceType() {
    }

    public ServiceType(Integer id, String name, Set<Service> services) {
        this.id = id;
        this.name = name;
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

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }
}
