package com.bbp.warehouseservice.facade;

import com.bbp.warehouseservice.domain.Brand;
import com.bbp.warehouseservice.domain.Inventory;
import com.bbp.warehouseservice.facade.dto.InventoryCreateUpdateFacadeRequestDto;
import com.bbp.warehouseservice.service.BrandService;
import com.bbp.warehouseservice.service.CategoryService;
import com.bbp.warehouseservice.service.InventoryService;
import com.bbp.warehouseservice.service.mapper.InventoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class InventoryFacade {

    private final InventoryService inventoryService;
    private final CategoryService categoryService;
    private final BrandService brandService;
    private final InventoryMapper mapper;

    public Inventory readInventory(String inventoryId) {
        return inventoryService.readInventory(inventoryId);
    }

    public Page<Inventory> readInventories(Pageable pageable) {
        return inventoryService.readInventories(pageable);
    }

    public Inventory createInventory(InventoryCreateUpdateFacadeRequestDto requestDto) {
        var serviceRequestDto = mapper.toCreateUpdateServiceRequest(requestDto);
        serviceRequestDto.setCategory(categoryService.readCategory(requestDto.getCategoryId()));
        serviceRequestDto.setBrand(brandService.readBrand(requestDto.getBrandId()));

        return inventoryService.createInventory(serviceRequestDto);
    }

    public Inventory updateInventory(String inventoryId, InventoryCreateUpdateFacadeRequestDto requestDto) {
        var serviceRequestDto = mapper.toCreateUpdateServiceRequest(requestDto);
        serviceRequestDto.setCategory(categoryService.readCategory(requestDto.getCategoryId()));
        serviceRequestDto.setBrand(brandService.readBrand(requestDto.getBrandId()));

        return inventoryService.updateInventory(inventoryId, serviceRequestDto);
    }

    public void deleteInventory(String inventoryId) {
        inventoryService.deleteInventory(inventoryId);
    }

    public void reduceInventoryQuantity(String inventoryId, int quantity) {
        inventoryService.reduceInventoryQuantity(inventoryId, quantity);
    }
}
