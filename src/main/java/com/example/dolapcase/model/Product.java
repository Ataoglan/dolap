package com.example.dolapcase.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "products")
@Data
public class Product extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "explanation")
    private String explanation;

    @Column(name = "price")
    private long price;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Category category;

}
