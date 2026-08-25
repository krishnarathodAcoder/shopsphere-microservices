package com.shopsphere.categoryservice.service;

import com.shopsphere.categoryservice.Repository.CategoryRepository;
import com.shopsphere.categoryservice.dto.CategoryRequestDTO;
import com.shopsphere.categoryservice.dto.CategoryResponseDTO;
import com.shopsphere.categoryservice.entity.Category;
import com.shopsphere.categoryservice.exception.CategoryNotFoundException;
import com.shopsphere.categoryservice.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO)
    {
       Category category= CategoryMapper.toEntity(categoryRequestDTO);
        return CategoryMapper.toResponseDTO( categoryRepository.save(category));
    }
    public List<CategoryResponseDTO> getAllCategories() {

        return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::toResponseDTO)
                .toList();
    }

    public CategoryResponseDTO getCategoryById(Long id)
    {
       Category category= categoryRepository.findById(id).orElseThrow(()-> new CategoryNotFoundException("Category  not found with id=" +id));
       return CategoryMapper.toResponseDTO(category);
    }
    public void deleteCategory(Long id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() ->
                        new CategoryNotFoundException(
                                "Category not found with id: " + id));

        categoryRepository.delete(category);
    }

    public CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO requestDTO) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() ->
                        new CategoryNotFoundException(
                                "Category not found with id: " + id));

        category.setName(requestDTO.getName());
        category.setDescription(requestDTO.getDescription());

        Category updatedCategory = categoryRepository.save(category);

        return CategoryMapper.toResponseDTO(updatedCategory);
    }

}
