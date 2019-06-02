package com.bbp.warehouseservice.facade;

import com.bbp.warehouseservice.domain.Brand;
import com.bbp.warehouseservice.facade.dto.BrandCreateUpdateFacadeRequestDto;
import com.bbp.warehouseservice.service.BrandService;
import com.bbp.warehouseservice.service.mapper.BrandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class BrandFacade {

    private final BrandService brandService;
    private final BrandMapper mapper;

    public Brand readBrand(String brandId) {
        return brandService.readBrand(brandId);
    }

    public Page<Brand> readBrand(Pageable pageable) {
        return brandService.readBrand(pageable);
    }

    public Brand createBrand(BrandCreateUpdateFacadeRequestDto requestDto) {
        var serviceRequestDto = mapper.toCreateUpdateServiceRequest(requestDto);
        return brandService.createBrand(serviceRequestDto);
    }

    public Brand updateBrand(String brandId, BrandCreateUpdateFacadeRequestDto requestDto) {
        var serviceRequestDto = mapper.toCreateUpdateServiceRequest(requestDto);
        return brandService.updateBrand(brandId, serviceRequestDto);
    }

    public void deleteBrand(String brandId) {
        brandService.deleteBrand(brandId);
    }
}
