package com.bbp.warehouseservice.service;

import com.bbp.warehouseservice.domain.Inventory;
import com.bbp.warehouseservice.domain.Rate;
import com.bbp.warehouseservice.service.dto.RateCreateServiceRequestDto;
import com.bbp.warehouseservice.service.dto.RateUpdateServiceRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface RateService {

    Rate readRate(String rateId);

    Page<Rate> readRates(Inventory inventory, Pageable pageable);

    Rate createRate(RateCreateServiceRequestDto requestDto);

    Rate updateRate(String rateId, RateUpdateServiceRequestDto requestDto);

    void deleteRate(String id);

    float getAverageRate(Long inventoryId);

    Optional<Rate> getRateByInventoryAndUser(Long inventoryId, Long userId);
}
