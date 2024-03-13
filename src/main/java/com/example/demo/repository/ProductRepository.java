package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	
	//Costum Method
	
//	@Query("SELECT * FROM Product  WHERE productName=?1")
	@Query("SELECT p FROM Product p WHERE p.productName=?1")
	public abstract List<Product> findByProductName(String productName);
	
	
	@Query("SELECT p FROM Product p WHERE p.productPrice >?1 AND  p.productPrice <?2")
	public abstract List<Product> fetchProductByPrice(int startingPrice , int endingPrice);
	
	
	@Query("SELECT p FROM Product p WHERE p.productName Like '%?1%' ")
	public abstract List<Product> fetchByProductChar(Character containChar);
	
}


