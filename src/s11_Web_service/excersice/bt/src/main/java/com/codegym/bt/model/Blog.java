package com.codegym.bt.model;

import javax.persistence.*;

@Entity(name = "blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private String content;

    @Column(name = "date_create",columnDefinition = "DATE")
    private String dateCreate;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private com.codegym.bt.model.Category category;

    public com.codegym.bt.model.Category getCategory() {
        return category;
    }

    public void setCategory(com.codegym.bt.model.Category category) {
        this.category = category;
    }

    public Blog() {
    }

    public Blog(Integer id, String name, String content, String dateCreate, Category category) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.dateCreate = dateCreate;
        this.category = category;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}