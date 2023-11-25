package com.infy.DebEcommerce.data;

import lombok.Data;

@Data
public class ProductCreationRequest {
    private String name;
    private String description;
    private long price;
    private String categoryId;
}