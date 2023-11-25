package com.infy.DebEcommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.infy.DebEcommerce.data.CategoryCreationRequest;
import com.infy.DebEcommerce.data.ProductCreationRequest;
import com.infy.DebEcommerce.exception.ResourceNotFoundException;
import com.infy.DebEcommerce.model.Category;
import com.infy.DebEcommerce.model.Product;
import com.infy.DebEcommerce.repository.CategoryRepository;
import com.infy.DebEcommerce.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EcommerceService {

	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;

	public Category createCategory(CategoryCreationRequest request) {
		Category category = new Category();
		BeanUtils.copyProperties(request, category);
		return categoryRepository.save(category);
	}
	
    public Category getCategoryById(String id) throws ResourceNotFoundException{
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            return category.get();
        }
        throw new ResourceNotFoundException("Cant find any category under given ID");
    }

	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}
	
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public Product createProduct(ProductCreationRequest product) throws ResourceNotFoundException {
		Optional<Category> category = categoryRepository.findById(product.getCategoryId());
		if (!category.isPresent()) {
			throw new ResourceNotFoundException("Category Not Found");
		}
		Product productToCreate = new Product();
		BeanUtils.copyProperties(product, productToCreate);
		productToCreate.setCategory(category.get());
		return productRepository.save(productToCreate);
	}
	
	 public void deleteCategory(String id) {
		 productRepository.deleteById(id);
	    }
	
	 
	 public void deleteProduct(String id) {
		 categoryRepository.deleteById(id);
	    }

	public List<Product> getProductsByCatId(String categoryId) throws ResourceNotFoundException {
		
		return productRepository.findAllbyCategory(categoryId);
	}

	public Product getProductById(String productId) throws ResourceNotFoundException {
		   Optional<Product> product = productRepository.findById(productId);
	        if (product.isPresent()) {
	            return product.get();
	        }
	        throw new ResourceNotFoundException("Cant find any product under given ID");
	}
	

}
