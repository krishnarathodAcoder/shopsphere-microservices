package com.shopsphere.productservice.dto;

public class ProductResponseDTO {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;

    public ProductResponseDTO() {
    }

    public ProductResponseDTO(Long id, String name, String description,
                              Double price, Integer stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    // Generate getters and setters using:
    // Alt + Insert → Getter and Setter

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStock(Integer stock) {
        this.stock=stock;
    }
    public Integer getStock()
    {
        return stock;
    }
}