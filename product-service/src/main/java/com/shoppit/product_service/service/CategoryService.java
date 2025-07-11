package com.shoppit.product_service.service;

import com.shoppit.product_service.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getAllCategories();
    Optional<Category> getCategoryById(Long id);
    Category createCategory(Category category);
    Optional<Category> updateCategory(Long id, Category categoryDetails);
    boolean deleteCategory(Long id);

}
