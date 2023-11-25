package com.infy.DebEcommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.infy.DebEcommerce.model.Category;
import com.infy.DebEcommerce.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

	
	@Query("{ 'category': {'$ref': 'category', '$id': { '$oid': ?0 } } }")
	List<Product> findAllbyCategory(String categoryId);
}
