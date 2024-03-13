package com.example.demo.utility;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.ProductNotFoundByIdException;

//@ControllerAdvice
//@ResponseBody


@RestControllerAdvice

public class ApplicationHandler {


	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> productNotFoundById(ProductNotFoundByIdException ex){

		ErrorStructure<String> errorStructure = new ErrorStructure<>();
		errorStructure.setErrorStatusCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setErrorMessage(ex.getMessage());
		errorStructure.setErrorData("Product With the Requested Id is Not Present" );

		return new ResponseEntity<ErrorStructure<String>>(errorStructure,HttpStatus.NOT_FOUND);


	}
}
