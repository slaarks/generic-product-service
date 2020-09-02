package com.fluko.cloud.productservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fluko.cloud.productservice.entity.ProductEntity;
import com.fluko.cloud.productservice.repository.ProductRepository;

@RestController
@RequestMapping("/store")
public class ProductController {
	

	@Autowired
	ProductRepository productRepository;

	//CREATE
	@PostMapping(path = "/product", consumes = "application/json", produces = "application/json")
	public ProductEntity create(@RequestBody ProductEntity productEntity){
		productRepository.save(productEntity);
		return productEntity;
	}
	
	//READ ALL
	@GetMapping("/products")
	public List<ProductEntity> findAll(){
		List<ProductEntity> customers = productRepository.findAll();
		return customers;
	}
	
	//READ ONE
	@GetMapping("/products/{id}")
	public Optional<ProductEntity> findOne(@PathVariable long id){
		Optional<ProductEntity> productEntity  = productRepository.findById(id);
		return productEntity;
	}
	
	//UPDATE
	@PutMapping(path = "/product", consumes = "application/json", produces = "application/json")
	public ProductEntity update(@RequestBody ProductEntity productEntity){
		productRepository.save(productEntity);
		return productEntity;
	}
	
	//DELETE
	@DeleteMapping(path = "/product", consumes = "application/json", produces = "application/json")
	public ProductEntity delte(@RequestBody ProductEntity productEntity){
		productRepository.delete(productEntity);
		return productEntity;
	}
}
