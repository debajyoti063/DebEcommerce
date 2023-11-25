package com.infy.DebEcommerce.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Category {
    @Id
    private String id;
    private String name;
    private String description;
    
    @Transient
    public static final String SEQUENCE_NAME = "category_sequence";
}