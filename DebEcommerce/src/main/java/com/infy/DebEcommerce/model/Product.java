package com.infy.DebEcommerce.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Product {

    @Id
    private String id;
    private long price;
    private String name;
    private String description;
    
    @Transient
    public static final String SEQUENCE_NAME = "product_sequence";
    
    @DBRef
    private Category category;

}