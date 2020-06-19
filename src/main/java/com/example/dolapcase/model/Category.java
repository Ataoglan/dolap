package com.example.dolapcase.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.function.Function;

@Entity(name = "categories")
@Data
public class Category extends BaseEntity{

    @Column(name = "name")
    private String name;

}
