package com.shopsphere.categoryservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false,length = 100,unique = true)
    private  String name;

    @Column(length = 500)
    private String description;

    public Category(Long id,String name , String description, Boolean active) {
        this.name = name;
        this.description=description;
        this.id=id;
        this.name=name;

    }

    public Category() {
    }

    @Column(nullable = false)
    private  Boolean active=true;

    public Category(Long id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
