package com.bbp.warehouseservice.facade;

import com.bbp.warehouseservice.domain.Category;
import com.bbp.warehouseservice.facade.dto.CategoryCreateUpdateFacadeRequestDto;
import com.bbp.warehouseservice.service.CategoryService;
import com.bbp.warehouseservice.service.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
//TODO IMPLEMENT CLOSURE TABLE tree logic
public class CategoryFacade {

    private final CategoryService categoryService;
    private final CategoryMapper mapper;

    public Category readCategory(String categoryId) {
        return categoryService.readCategory(categoryId);
    }

    public Page<Category> readCategories(Pageable pageable) {
        return categoryService.readCategories(pageable);
    }

    public Category createCategory(CategoryCreateUpdateFacadeRequestDto requestDto) {
        var serviceRequestDto = mapper.toCreateUpdateServiceRequest(requestDto);
        return categoryService.createCategory(serviceRequestDto);
    }

    public Category updateCategory(String categoryId, CategoryCreateUpdateFacadeRequestDto requestDto) {
        var serviceRequestDto = mapper.toCreateUpdateServiceRequest(requestDto);
        return categoryService.updateCategory(categoryId, serviceRequestDto);
    }

    public void deleteCategory(String categoryId) {
        categoryService.deleteCategory(categoryId);
    }
}