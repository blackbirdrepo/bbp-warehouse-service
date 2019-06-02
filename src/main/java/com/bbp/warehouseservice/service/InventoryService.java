package com.bbp.warehouseservice.service;


import com.bbp.warehouseservice.domain.Inventory;
import com.bbp.warehouseservice.service.dto.InventoryCreateUpdateServiceRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.PageableExecutionUtils;

public interface InventoryService {

    Inventory readInventory(String id);

    Page<Inventory> readInventories(Pageable pageable);

    Inventory createInventory(InventoryCreateUpdateServiceRequestDto requestDto);

    Inventory updateInventory(String inventoryId, InventoryCreateUpdateServiceRequestDto requestDto);

    void deleteInventory(String id);

    void reduceInventoryQuantity(String inventoryId, int quantity);
}
