package com.bbp.warehouseservice.service.impl;

import com.bbp.warehouseservice.domain.Category;
import com.bbp.warehouseservice.repository.CategoryRepository;
import com.bbp.warehouseservice.repository.CategoryTreePathRepository;
import com.bbp.warehouseservice.service.CategoryService;
import com.bbp.warehouseservice.service.dto.CategoryCreateUpdateServiceRequestDto;
import com.bbp.warehouseservice.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryJpaService implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryTreePathRepository categoryTreePathRepository;

    @Override
    public Category readCategory(String id) {
        return categoryRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new ObjectNotFoundException(String.format("Category with id: %s not found", id)));
    }

    //TODO remove
    @Override
    public Page<Category> readCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Category createCategory(CategoryCreateUpdateServiceRequestDto requestDto) {
        var currentCategory = categoryRepository.save(Category.create(requestDto.getName()));

        Optional
                .ofNullable(requestDto.getParentId())
                .map(this::readCategory)
                .map(Category::getId)
                .ifPresentOrElse(
                        (id) -> categoryTreePathRepository.insertNestedCategoryPath(id, currentCategory.getId()),
                        () -> categoryTreePathRepository.insertRootCategoryPath(currentCategory.getId()));

        return currentCategory;
    }

    @Override
    public Category updateCategory(String categoryId, CategoryCreateUpdateServiceRequestDto requestDto) {
        var category = readCategory(categoryId)
                .setName(requestDto.getName());
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(String id) {
        categoryRepository.delete(readCategory(id));
    }
}
