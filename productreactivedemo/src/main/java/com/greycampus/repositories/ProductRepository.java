package com.greycampus.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.greycampus.entities.ProductEntity;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<ProductEntity, String> {

}