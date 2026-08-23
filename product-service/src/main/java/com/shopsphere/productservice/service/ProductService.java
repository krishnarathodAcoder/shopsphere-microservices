package com.shopsphere.productservice.service;

import com.shopsphere.productservice.dto.ProductRequestDTO;
import com.shopsphere.productservice.dto.ProductResponseDTO;
import com.shopsphere.productservice.entity.Product;
import com.shopsphere.productservice.exception.ProductNotFoundException;
import com.shopsphere.productservice.mapper.ProductMapper;
import com.shopsphere.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProductService {
    private  final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository)
    {
        this.productRepository=productRepository;
    }

    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO)
    {
         Product product=ProductMapper.toEntity(productRequestDTO);
         Product savedProduct=productRepository.save(product);
         return ProductMapper.toResponseDTO(savedProduct);
    }

    public List<ProductResponseDTO> getAllProducts()
    {
        List<Product> productList= productRepository.findAll();
        return  productList.stream().map(ProductMapper::toResponseDTO).toList();
    }
    public  ProductResponseDTO getProductById(Long id)
    {

        Product product= productRepository.findById(id).orElseThrow(()->new ProductNotFoundException("Product not found exception"));

        return ProductMapper.toResponseDTO(product);
    }
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO)
    {
        Product product= productRepository.findById(id).orElseThrow(
                ()->new ProductNotFoundException("Product Not Found Exception"+id));

        product.setName(productRequestDTO.getName());
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice(productRequestDTO.getPrice());
        product.setStock(productRequestDTO.getStock());

        Product updatedProduct= productRepository.save(product);
        return ProductMapper.toResponseDTO(updatedProduct);
    }


    public void deleteProductById(Long id)
    {
        Product product= productRepository.findById(id).orElseThrow(
                ()->new ProductNotFoundException("Product Not Found Exception"+id));

        productRepository.delete(product);
    }


}