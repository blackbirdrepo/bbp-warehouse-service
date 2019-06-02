package com.bbp.warehouseservice.service.mapper;

import com.bbp.warehouseservice.domain.Category;
import com.bbp.warehouseservice.facade.dto.CategoryCreateUpdateFacadeRequestDto;
import com.bbp.warehouseservice.rest.dto.CategoryCreateUpdateRestRequestDto;
import com.bbp.warehouseservice.rest.dto.CategoryRestResponseDto;
import com.bbp.warehouseservice.service.dto.CategoryCreateUpdateServiceRequestDto;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryCreateUpdateFacadeRequestDto toCreateUpdateFacadeRequest(CategoryCreateUpdateRestRequestDto requestDto);

    CategoryCreateUpdateServiceRequestDto toCreateUpdateServiceRequest(CategoryCreateUpdateFacadeRequestDto requestDto);

    CategoryRestResponseDto toRestResponse(Category category);

    default Page<CategoryRestResponseDto> toRestResponsePage(Page<Category> categoryPage) {
        return categoryPage.map(this::toRestResponse);
    }
}
