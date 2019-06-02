package com.bbp.warehouseservice.service.impl;

import com.bbp.warehouseservice.domain.Brand;
import com.bbp.warehouseservice.domain.enums.CountryEnum;
import com.bbp.warehouseservice.repository.BrandRepository;
import com.bbp.warehouseservice.service.BrandService;
import com.bbp.warehouseservice.service.dto.BrandCreateUpdateServiceRequestDto;
import com.bbp.warehouseservice.service.exception.ObjectNotFoundException;
import com.bbp.warehouseservice.service.mapper.BrandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BrandJpaService implements BrandService {

    private final BrandRepository repository;

    @Override
    public Brand readBrand(String brandId) {
        return repository.findById(Long.valueOf(brandId))
                .orElseThrow(() -> new ObjectNotFoundException(String.format("Brand with id: %s not found", brandId)));
    }

    @Override
    public Page<Brand> readBrand(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Brand createBrand(BrandCreateUpdateServiceRequestDto requestDto) {
        var brand = Brand.create(
                requestDto.getName(),
                CountryEnum.valueOf(requestDto.getCountry().toUpperCase()),
                requestDto.isPremium());
        return repository.save(brand);
    }

    @Override
    public Brand updateBrand(String brandId, BrandCreateUpdateServiceRequestDto requestDto) {
        var brand = readBrand(brandId);
        brand
                .setName(requestDto.getName())
                .setCountry(CountryEnum.valueOf(requestDto.getCountry().toUpperCase()))
                .setPremium(requestDto.isPremium());
        return repository.save(brand);
    }

    @Override
    public void deleteBrand(String brandId) {
        repository.delete(readBrand(brandId));
    }
}
