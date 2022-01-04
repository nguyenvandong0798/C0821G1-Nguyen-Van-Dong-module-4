package com.codegym.teamilk.model;

import javax.persistence.*;

@Entity(name = "tea_milk")
public class Tea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name ="name")
    private String name;
    @Column(name = "price")
    private String price;
    @ManyToOne
    @JoinColumn(name = "idd")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Tea(Integer id, String name, String price, Category categories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = categories;
    }

    public Tea(Integer id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Tea() {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
