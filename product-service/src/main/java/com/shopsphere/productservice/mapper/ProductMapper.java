package com.shopsphere.productservice.mapper;

import com.shopsphere.productservice.dto.ProductRequestDTO;
import com.shopsphere.productservice.dto.ProductResponseDTO;
import com.shopsphere.productservice.entity.Product;

public class ProductMapper {

    public static Product toEntity(ProductRequestDTO productRequestDTO)
    {
        Product product=new Product();
        product.setName(productRequestDTO.getName());
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice(productRequestDTO.getPrice());
        product.setStock(productRequestDTO.getStock());

        return   product;
    }
    public static ProductResponseDTO toResponseDTO(Product product) {

        ProductResponseDTO dto = new ProductResponseDTO();

        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setStock(product.getStock());

        return dto;
    }

}