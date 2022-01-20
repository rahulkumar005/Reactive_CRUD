package com.greycampus.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "productsdata")
public class ProductEntity {

	private String id;
	private String product_name;
	private String qty;
	private String price;

}
