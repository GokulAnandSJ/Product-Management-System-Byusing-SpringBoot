package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.exception.ProductNotFoundByIdException;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import com.example.demo.utility.ResponseStructure;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	public ProductRepository pr;


	@Override
	public ResponseEntity<ResponseStructure<Product>> addProduct(Product product) {
		 Product product1 = pr.save(product);
		 
		 ResponseStructure<Product> reponseStructure = new ResponseStructure<>();
		 reponseStructure.setStatusCode(HttpStatus.CREATED.value());
		 reponseStructure.setMessage("Product Object Created Sucessfully");
		 reponseStructure.setData(product1);
		 
		 return new ResponseEntity<ResponseStructure<Product>>(reponseStructure,HttpStatus.CREATED);
		 
	}


	@Override
	public ResponseEntity<ResponseStructure<Product>> findProductById(int productId) {
		Optional<Product> opt = pr.findById(productId);

		if(opt.isPresent()) {
			Product product = opt.get();
			
			 ResponseStructure<Product> reponseStructure = new ResponseStructure<>();
			 reponseStructure.setStatusCode(HttpStatus.FOUND.value());
			 reponseStructure.setMessage("Product Object Found Sucessfully");
			 reponseStructure.setData(product);
			 
			return new ResponseEntity<ResponseStructure<Product>>(reponseStructure,HttpStatus.FOUND);
		}
		else {
			throw new  ProductNotFoundByIdException("Entered Product Id is Not Found");
		}
	}


	@Override
	public ResponseEntity<ResponseStructure<Product>> updateByProductId(int productId, Product updatedProduct) {
		Optional<Product> opt = pr.findById(productId);

		if(opt.isPresent()) {
			Product existingProduct = opt.get();
			updatedProduct.setProductId(existingProduct.getProductId());
			pr.save(updatedProduct);
			
			 ResponseStructure<Product> reponseStructure = new ResponseStructure<>();
			 reponseStructure.setStatusCode(HttpStatus.OK.value());
			 reponseStructure.setMessage("Product Object UPDATED Sucessfully");
			 reponseStructure.setData(updatedProduct);
			
			
			return new ResponseEntity<ResponseStructure<Product>>(reponseStructure,HttpStatus.OK);
		}
		else {
			throw new  ProductNotFoundByIdException("Entered Product Id is Not Found");
		}
	}


	@Override
	public ResponseEntity<ResponseStructure<Product>> deleteProductById(int productId) {
		Optional<Product> opt = pr.findById(productId);

		if(opt.isPresent()) {
			Product deleteProduct = opt.get();
			pr.delete(deleteProduct);
			
			
			 ResponseStructure<Product> reponseStructure = new ResponseStructure<>();
			 reponseStructure.setStatusCode(HttpStatus.OK.value());
			 reponseStructure.setMessage("Product Object DELETE Sucessfully");
			 reponseStructure.setData(deleteProduct);
			
			return new  ResponseEntity<ResponseStructure<Product>>(reponseStructure,HttpStatus.OK);
		}
		else {

			throw new  ProductNotFoundByIdException("Entered Product Id is Not Found");

		}
	}


	@Override
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProduct() {
		List<Product> products = pr.findAll();
		

		 ResponseStructure<List<Product>> reponseStructure = new ResponseStructure<>();
		 reponseStructure.setStatusCode(HttpStatus.FOUND.value());
		 reponseStructure.setMessage("List OF Product SHOWS Sucessfully");
		 reponseStructure.setData(products);
		
		return new  ResponseEntity<ResponseStructure<List<Product>>> (reponseStructure,HttpStatus.FOUND);
	}


	@Override
	public ResponseEntity<ResponseStructure<List<Product>>> findByProductName(String productName) {
		
		
		
		List<Product> product = (List<Product>) pr.findByProductName(productName);
		
		 ResponseStructure<List<Product>> reponseStructure = new ResponseStructure<>();
		 reponseStructure.setStatusCode(HttpStatus.FOUND.value());
		 reponseStructure.setMessage("List OF Product SHOWS Sucessfully");
		 reponseStructure.setData(product);
		return new ResponseEntity<ResponseStructure<List<Product>>> (reponseStructure,HttpStatus.FOUND);
	}
	@Override
	public ResponseEntity<ResponseStructure<List<Product>>> fetchProductByPrice(int startingPrice, int endingPrice) {

		List<Product> product = pr.fetchProductByPrice(startingPrice, endingPrice);

		ResponseStructure<List<Product>> reponseStructure = new ResponseStructure<>();
		reponseStructure.setStatusCode(HttpStatus.FOUND.value());
		reponseStructure.setMessage("Product Data Found Sucessfully");
		reponseStructure.setData(product);

		return new ResponseEntity<ResponseStructure<List<Product>>> (reponseStructure,HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Product>>> fetchByProductChar(Character containChar) {

		List<Product> product = pr.fetchByProductChar(containChar);

		ResponseStructure<List<Product>> reponseStructure = new ResponseStructure<>();
		reponseStructure.setStatusCode(HttpStatus.FOUND.value());
		reponseStructure.setMessage("Product Data Found Sucessfully");
		reponseStructure.setData(product);

		return new ResponseEntity<ResponseStructure<List<Product>>> (reponseStructure,HttpStatus.FOUND);
		
	}
	
	
}
