package com.spring.data.jpa.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.data.jpa.entity.Product;
import com.spring.data.jpa.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public Product saveProduct(Product product) {
		return repository.save(product);
	}

	public List<Product> getProducts() {
		return repository.findAll();
	}

	public Product getProductById(int id) {
		return repository.findById(id).get();
	}

	public Product getProductByName(String name) {
		return repository.findByName(name);
	}

	public List<Product> getProductByType(String productType) {
		return repository.findByProductType(productType);
	}

	public List<Product> getProductWithPriceAndType(double price, String productType) {
		return repository.findByPriceAndProductType(price, productType);
	}

	public List<Product> getProductByPrice(double price) {

		return repository.getProductByPrice(price);

	}

	public Product updateProduct(int id, Product productRequest) {

		Product existingProduct = repository.findById(id).get();
		existingProduct.setName(productRequest.getName());
		existingProduct.setDescription(productRequest.getDescription());
		existingProduct.setPrice(productRequest.getPrice());
		existingProduct.setProductType(productRequest.getProductType());

		return repository.save(existingProduct);

	}

	public long deleteProduct(int id) {
		repository.deleteById(id);
		return repository.count();
	}

	public List<Product> getProductByMultiplePriceValue(List<Double> prices) {

		return repository.findByPriceIn(prices);
	}

	public List<Product> getProductByMultiplePriceRange(double minPrice, double maxPrice) {

		return repository.findByPriceBetween(minPrice, maxPrice);
	}

	public List<Product> getProductWithHigherPrice(double price) {

		return repository.findAllByPriceGreaterThan(price);
	}

	public List<Product> getProductWithLessPrice(double price) {

		return repository.findAllByPriceLessThan(price);
	}
	
	public List<Product> getProductWithLike(String name){
		
		return repository.findByNameIgnoreCaseContaining(name);

	}
	
	
	//Sorting
	public List<Product> getProductWithSorting(String fieldName){
		
		return repository.findAll(Sort.by(Sort.Direction.ASC, fieldName));
	}
	
	//pagination
	
	public Page<Product> getPrdouctWithPageResponse(int offset, int limit){
		
		return repository.findAll(PageRequest.of(offset, limit));
	}
	

}
