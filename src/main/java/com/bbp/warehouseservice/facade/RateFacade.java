package com.bbp.warehouseservice.facade;

import com.bbp.warehouseservice.domain.Rate;
import com.bbp.warehouseservice.facade.dto.RateAverageFacadeResponseDto;
import com.bbp.warehouseservice.facade.dto.RateCreateUpdateFacadeRequestDto;
import com.bbp.warehouseservice.facade.dto.RateCreateUpdateFacadeRequestDto;
import com.bbp.warehouseservice.service.InventoryService;
import com.bbp.warehouseservice.service.RateService;
import com.bbp.warehouseservice.service.exception.ObjectAlreadyExistsException;
import com.bbp.warehouseservice.service.mapper.RateMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class RateFacade {

    private final RateService rateService;
    private final InventoryService inventoryService;
    private final RateMapper mapper;

    public Rate readRate(String inventoryId, String rateId) {
        inventoryService.readInventory(inventoryId);
        return rateService.readRate(rateId);
    }

    public Page<Rate> readRates(String inventoryId, Pageable pageable) {
        var inventory = inventoryService.readInventory(inventoryId);
        return rateService.readRates(inventory, pageable);
    }

    public Rate createRate(String inventoryId, RateCreateUpdateFacadeRequestDto requestDto) {
        var inventory = inventoryService.readInventory(inventoryId);
        //TODO replace hardcode with user from security context
        var userId = 1L;

        if (rateService.getRateByInventoryAndUser(inventory.getId(), userId).isPresent()) {
            throw new ObjectAlreadyExistsException(
                    String.format("Rate for inventory with id: %s already exists", inventoryId));
        }
        var serviceRequestDto = mapper.toCreateServiceRequest(requestDto);
        serviceRequestDto.setInventory(inventory);
        serviceRequestDto.setUserId(userId);
        return rateService.createRate(serviceRequestDto);
    }

    public Rate updateRate(String inventoryId, String rateId, RateCreateUpdateFacadeRequestDto requestDto) {
        inventoryService.readInventory(inventoryId);
        var serviceRequestDto = mapper.toUpdateServiceRequest(requestDto);
        return rateService.updateRate(rateId, serviceRequestDto);
    }

    public void deleteRate(String inventoryId, String rateId) {
        inventoryService.readInventory(inventoryId);
        rateService.deleteRate(rateId);
    }

    public RateAverageFacadeResponseDto getAverageRate(String inventoryId) {
        var inventory = inventoryService.readInventory(inventoryId);
        float averageScore = rateService.getAverageRate(inventory.getId());
        return RateAverageFacadeResponseDto.create(averageScore, inventory);
    }
}
