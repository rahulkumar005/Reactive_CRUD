package com.greycampus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greycampus.dto.ProductDto;
import com.greycampus.entities.ProductEntity;
import com.greycampus.services.ProductServices;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductServices productServices;

	@GetMapping
	public Flux<ProductDto> getAllProducts() {
		return productServices.getAllProducts();
	}

	@GetMapping("/{id}")
	public Mono<ProductEntity> getProductbyId(@PathVariable String id) {
		return productServices.getProductbyId(id);
	}

	@PostMapping("/save")
	public Mono<ProductDto> saveproduct(@RequestBody Mono<ProductDto> productDto) {
		return productServices.saveProduct(productDto);
	}

	@PutMapping("/update/{id}")
	public Mono<ProductDto> updateProduct(@RequestBody Mono<ProductDto> proMono, @PathVariable String id) {

		return productServices.updateProduct(proMono, id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable String id) {
		return productServices.delete(id);

	}
}
