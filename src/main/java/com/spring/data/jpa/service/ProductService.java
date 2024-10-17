package com.spring.data.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	public List<Product> getProducts(){
		return repository.findAll();
	}
	
	
	public Product getProductById(int id) {
		return repository.findById(id).get();
	}
	
	public Product getProductByName(String name) {
		return repository.findByName(name);
    }
	
	
	public List<Product> getProductByType(String productType){
		return repository.findByProductType(productType);
	}
	
	
	public List<Product> getProductWithPriceAndType(double price, String productType){
		return repository.findByPriceAndProductType(price, productType);
	}
	
	
	public List<Product> getProductByPrice(double price){
		
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
	
}
