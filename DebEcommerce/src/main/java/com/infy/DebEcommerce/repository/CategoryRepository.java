package com.infy.DebEcommerce.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.infy.DebEcommerce.model.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {
}
