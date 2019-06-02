package com.bbp.warehouseservice.service.impl;

import com.bbp.warehouseservice.domain.Inventory;
import com.bbp.warehouseservice.repository.InventoryRepository;
import com.bbp.warehouseservice.service.InventoryService;
import com.bbp.warehouseservice.service.dto.InventoryCreateUpdateServiceRequestDto;
import com.bbp.warehouseservice.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
@Service
public class InventoryJpaService implements InventoryService {

    private final InventoryRepository repository;

    @Override
    public Inventory readInventory(String inventoryId) {
        return repository
                .findById(Long.valueOf(inventoryId))
                .orElseThrow(() -> new ObjectNotFoundException(String.format("Inventory with id: %s not found", inventoryId)));
    }

    @Override
    public Page<Inventory> readInventories(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Inventory createInventory(InventoryCreateUpdateServiceRequestDto requestDto) {
        var inventory = Inventory.create(
                requestDto.getSku(),
                requestDto.getName(),
                requestDto.getModel(),
                requestDto.getPrice(),
                requestDto.getQuantity(),
                requestDto.getBrand(),
                requestDto.getCategory());
        return repository.save(inventory);
    }

    @Override
    public Inventory updateInventory(String inventoryId, InventoryCreateUpdateServiceRequestDto requestDto) {
        var inventory = readInventory(inventoryId)
                .setSku(requestDto.getSku())
                .setName(requestDto.getName())
                .setModel(requestDto.getModel())
                .setPrice(requestDto.getPrice())
                .setQuantity(requestDto.getQuantity())
                .setBrand(requestDto.getBrand())
                .setCategory(requestDto.getCategory());
        return repository.save(inventory);
    }

    @Override
    public void deleteInventory(String inventoryId) {
        repository.delete(readInventory(inventoryId));
    }

    @Override
    public void reduceInventoryQuantity(String inventoryId, int quantity) {
        var inventory = readInventory(inventoryId);
        repository.reduceInventoryQuantity(inventory, quantity);
    }
}
