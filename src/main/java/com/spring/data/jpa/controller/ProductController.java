package com.spring.data.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.data.jpa.entity.Product;
import com.spring.data.jpa.repository.ProductRepository;
import com.spring.data.jpa.service.ProductService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}

	@GetMapping
	public List<Product> getProducts() {
		return service.getProducts();
	}

	@GetMapping("/id/{id}")
	public Product getProductById(@PathVariable int id) {
		return service.getProductById(id);
	}

	@GetMapping("/name/{name}")
	public Product getProductByName(@PathVariable String name) {
		return service.getProductByName(name);
	}

	@GetMapping("/type/{productType}")
	public List<Product> getProductByType(@PathVariable String productType) {
		return service.getProductByType(productType);
	}

	@GetMapping("/{price}/{productType}")
	public List<Product> getProductWithPriceAndType(@PathVariable double price, @PathVariable String productType) {
		return service.getProductWithPriceAndType(price, productType);
	}

	@GetMapping("/{price}")
	public List<Product> getProductByPrice(@PathVariable double price) {

		return service.getProductByPrice(price);

	}

	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable int id, @RequestBody Product productRequest) {
		return service.updateProduct(id, productRequest);

	}

	@DeleteMapping("/delete/{id}")
	public long deleteProduct(@PathVariable int id) {

		return service.deleteProduct(id);
	}

	@PostMapping("/search")
	public List<Product> getProductByMultiplePriceValue(@RequestBody List<Double> prices) {

		return service.getProductByMultiplePriceValue(prices);
	}

	@GetMapping("/min/{minPrice}/max/{maxPrice}")
	public List<Product> getProductByMultiplePriceRange(@PathVariable double minPrice, @PathVariable double maxPrice) {

		return service.getProductByMultiplePriceRange(minPrice, maxPrice);
	}

	@GetMapping("/greater/{price}")
	public List<Product> getProductWithHigherPrice(@PathVariable double price) {

		return service.getProductWithHigherPrice(price);
	}

	@GetMapping("/less/{price}")
	public List<Product> getProductWithLessPrice(@PathVariable double price) {

		return service.getProductWithLessPrice(price);
	}

	@GetMapping("/like/{name}")
	public List<Product> getProductWithLike(@PathVariable String name) {

		return service.getProductWithLike(name);

	}

	@GetMapping("/sort/{fieldName}")
	public List<Product> getProductWithSorting(@PathVariable String fieldName) {

		return service.getProductWithSorting(fieldName);
	}

	// pagination

	@GetMapping("/page/{offset}/{limit}")
	public Page<Product> getPrdouctWithPageResponse(@PathVariable int offset, @PathVariable int limit) {

		return service.getPrdouctWithPageResponse(offset, limit);
	}

}
