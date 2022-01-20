package com.greycampus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greycampus.dto.ProductDto;
import com.greycampus.entities.ProductEntity;
import com.greycampus.repositories.ProductRepository;
import com.greycampus.utils.AppUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServices {

	@Autowired
	private ProductRepository productRepository;

	// Get the list of all product present in Database
	public Flux<ProductDto> getAllProducts() {
		return productRepository.findAll().map(AppUtils::entityToDto);
	}

	// Get the Single Product With the given id
	public Mono<ProductEntity> getProductbyId(String id) {
		return productRepository.findById(id);
	}

	// Save the new product data
	public Mono<ProductDto> saveProduct(Mono<ProductDto> proMono) {
		return proMono.map(AppUtils::dtoToEntity).flatMap(productRepository::insert).map(AppUtils::entityToDto);
	}

	// Update the product data with the given id
	public Mono<ProductDto> updateProduct(Mono<ProductDto> prodMono, String id) {
		return productRepository.findById(id).flatMap(p -> prodMono.map(AppUtils::dtoToEntity))
				.doOnNext(e -> e.setId(id)).flatMap(productRepository::save).map(AppUtils::entityToDto);
	}

	// removes the data of product with given id
	public String delete(String id) {
		productRepository.deleteById(id);
		return "deleted";

	}

}
