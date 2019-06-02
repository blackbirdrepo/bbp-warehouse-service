package com.bbp.warehouseservice.service;

import com.bbp.warehouseservice.domain.Category;
import com.bbp.warehouseservice.service.dto.CategoryCreateUpdateServiceRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {

    Category readCategory(String id);

    Page<Category> readCategories(Pageable pageable);

    Category createCategory(CategoryCreateUpdateServiceRequestDto requestDto);

    Category updateCategory(String categoryId, CategoryCreateUpdateServiceRequestDto requestDto);

    void deleteCategory(String id);
}