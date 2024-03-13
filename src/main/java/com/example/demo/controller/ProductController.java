package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import com.example.demo.utility.ResponseStructure;

//@Controller
//@ResponseBody

@RestController

public class ProductController {

	@Autowired
	public ProductService ps;

	//	@RequestMapping(value = "/product/addProduct", method = RequestMethod.POST)

	@PostMapping("/product/addProduct")

	public ResponseEntity<ResponseStructure<Product>> addProduct(@RequestBody Product product) {
		return ps.addProduct(product);
	}

	//	@RequestMapping(value = "/product/findProductById/{productId}",method =  RequestMethod.GET)

	@GetMapping("/product/findProductById/{productId}")

	public ResponseEntity<ResponseStructure<Product>> findProductById(@PathVariable  int productId) {
		return ps.findProductById(productId);
	}

	//	@RequestMapping(value = "/product/updateProductById/{productId}" , method = RequestMethod.PUT)

	@PutMapping("/product/updateProductById/{productId}")

	public ResponseEntity<ResponseStructure<Product>> updateProductByItId(@PathVariable int productId , @RequestBody Product product ) {
		return ps.updateByProductId(productId, product);
	}

	//	@RequestMapping(value = "/product/deleteProductById/{productId}" , method = RequestMethod.DELETE)

	@DeleteMapping("/product/deleteProductById/{productId}")

	public ResponseEntity<ResponseStructure<Product>> deleteProductById(@PathVariable int productId) {
		return ps.deleteProductById(productId);
	}

	//	@RequestMapping(value = "/product/findAllProduct" , method =RequestMethod.GET )

	@GetMapping("/product/findAllProduct")

	public ResponseEntity<ResponseStructure<List<Product>>> findAllProducts(){
		return ps.findAllProduct();

	}

	@GetMapping("/product/findByProducName/{productName}")

	public ResponseEntity<ResponseStructure<List<Product>>> findByProductName(@PathVariable String productName) {
		return ps.findByProductName(productName);
	}

	@GetMapping("/product/findProductByPrice/{startingPrice}/{endingPrice}")
	public ResponseEntity<ResponseStructure<List<Product>>> fetchProductByPrice(@PathVariable int startingPrice,@PathVariable int endingPrice){
		return ps.fetchProductByPrice(startingPrice, endingPrice);
	}


	@GetMapping("/product/findProductByItsNameContainAnyChar/{containChar}")
	public ResponseEntity<ResponseStructure<List<Product>>> fetchProductContainO(@PathVariable Character containChar){
		return ps.fetchByProductChar(containChar);
	}
}
