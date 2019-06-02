package com.bbp.warehouseservice.service.mapper;

import com.bbp.warehouseservice.domain.Brand;
import com.bbp.warehouseservice.facade.dto.BrandCreateUpdateFacadeRequestDto;
import com.bbp.warehouseservice.rest.dto.BrandCreateUpdateRestRequestDto;
import com.bbp.warehouseservice.rest.dto.BrandRestResponseDto;
import com.bbp.warehouseservice.service.dto.BrandCreateUpdateServiceRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    BrandCreateUpdateFacadeRequestDto toCreateUpdateFacadeRequest(BrandCreateUpdateRestRequestDto requestDto);

    BrandCreateUpdateServiceRequestDto toCreateUpdateServiceRequest(BrandCreateUpdateFacadeRequestDto requestDto);

    @Mapping(target = "country", expression = "java(brand.getCountry().name().toLowerCase())")
    BrandRestResponseDto toRestResponse(Brand brand);

    default Page<BrandRestResponseDto> toRestResponsePage(Page<Brand> brandPage) {
        return brandPage.map(this::toRestResponse);
    }
}
