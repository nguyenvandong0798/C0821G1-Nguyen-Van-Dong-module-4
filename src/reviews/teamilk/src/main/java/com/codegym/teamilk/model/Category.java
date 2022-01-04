package com.codegym.teamilk.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "size")
    private String size;
    @OneToMany(mappedBy = "category")
    private Set<Tea> tea;

    public Set<Tea> getTea() {
        return tea;
    }

    public void setTea(Set<Tea> teaMilk) {
        this.tea = teaMilk;
    }

    public Category(Integer id, String size, Set<Tea> teaMilk) {
        this.id = id;
        this.size = size;
        this.tea = teaMilk;
    }

    public Category(Integer id, String size) {
        this.id = id;
        this.size = size;
    }

    public Category() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
