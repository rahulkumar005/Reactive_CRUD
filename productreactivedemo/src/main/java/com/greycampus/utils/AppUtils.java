package com.greycampus.utils;

import org.springframework.beans.BeanUtils;

import com.greycampus.dto.ProductDto;
import com.greycampus.entities.ProductEntity;

public class AppUtils {

	public static ProductDto entityToDto(ProductEntity productEntity) {
		ProductDto productDto = new ProductDto();
		BeanUtils.copyProperties(productEntity, productDto);
		return productDto;

	}

	public static ProductEntity dtoToEntity(ProductDto productDto) {
		ProductEntity productEntity = new ProductEntity();
//		if(productDto==null) {
//			return productEntity;
//		}else if(productDto.getPrice()==null & productDto.getProduct_name()==null ) {
//				productEntity.setQty(productDto.getQty());
//		}else if(productDto.getPrice()==null & productDto.getQty()==null) {
//				productEntity.setProduct_name(productDto.getProduct_name());
//		}else if(productDto.getProduct_name()==null & productDto.getQty()==null) {
//				productEntity.setPrice(productDto.getPrice());
//		}else if(productDto.getPrice()!=null) {
//			     
//		}
			
		BeanUtils.copyProperties(productDto, productEntity);
		return productEntity;

	}

}
