package com.bbp.warehouseservice.service;

import com.bbp.warehouseservice.domain.Brand;
import com.bbp.warehouseservice.service.dto.BrandCreateUpdateServiceRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BrandService {

    Brand readBrand(String id);

    Page<Brand> readBrand(Pageable pageable);

    Brand createBrand(BrandCreateUpdateServiceRequestDto requestDto);

    Brand updateBrand(String brandId, BrandCreateUpdateServiceRequestDto requestDto);

    void deleteBrand(String id);
}
