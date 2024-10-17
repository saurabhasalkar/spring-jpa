package com.spring.data.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.spring.data.jpa.entity.Product;

public interface ProductRepository  extends JpaRepository<Product, Integer>{
	
	
	Product findByName(String name);

	List<Product> findByProductType(String productType);

	
	List<Product> findByPriceAndProductType(double price, String productType);
	 
//	@Query(value = "select * from product_tbl where price = ?1", nativeQuery = true)
	
	@Query("from Product p where p.price= ?1") //position parameter
	List<Product> getProductByPrice(double price);
}
