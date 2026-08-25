package com.shopsphere.categoryservice.mapper;

import com.shopsphere.categoryservice.dto.CategoryRequestDTO;
import com.shopsphere.categoryservice.dto.CategoryResponseDTO;
import com.shopsphere.categoryservice.entity.Category;

public class CategoryMapper {

    public static Category toEntity(CategoryRequestDTO categoryRequestDTO) {
        Category category = new Category();
        category.setName(categoryRequestDTO.getName());
        category.setDescription(categoryRequestDTO.getDescription());
        category.setActive(true);
        return category;
    }

    public static CategoryResponseDTO toResponseDTO(Category category)
    {
        CategoryResponseDTO categoryResponseDTO  =new CategoryResponseDTO();

        categoryResponseDTO.setId(category.getId());
        categoryResponseDTO.setName(category.getName());
        categoryResponseDTO.setActive(category.getActive());
        categoryResponseDTO.setDescription(category.getDescription());
        return categoryResponseDTO;

    }
}
