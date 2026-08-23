package com.shopsphere.productservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class ProductRequestDTO {

    @NotBlank(message = "Product name is required")
    private String name;

    @NotBlank(message = "Product description is required")
    private String description;

    @Positive(message = "Price must be greater than 0")
    private Double  price;

    @PositiveOrZero(message = "Stock cannot be negative")
    private Integer stock;
    public ProductRequestDTO() {
    }
    public ProductRequestDTO(String name, String description,Double price, Integer stock) {
        this.name = name;
        this.description=description;
        this.price=price;
        this.stock=stock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
