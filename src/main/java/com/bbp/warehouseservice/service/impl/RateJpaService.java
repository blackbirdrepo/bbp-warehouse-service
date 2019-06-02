package com.bbp.warehouseservice.service.impl;

import com.bbp.warehouseservice.domain.Inventory;
import com.bbp.warehouseservice.domain.Rate;
import com.bbp.warehouseservice.repository.RateRepository;
import com.bbp.warehouseservice.service.RateService;
import com.bbp.warehouseservice.service.dto.RateCreateServiceRequestDto;
import com.bbp.warehouseservice.service.dto.RateUpdateServiceRequestDto;
import com.bbp.warehouseservice.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RateJpaService implements RateService {

    private final RateRepository repository;

    @Override
    public Rate readRate(String id) {
        return repository.findById(Long.valueOf(id))
                .orElseThrow(() -> new ObjectNotFoundException(String.format("Rate with id: %s not found", id)));
    }

    @Override
    public Page<Rate> readRates(Inventory inventory, Pageable pageable) {
        return repository.findAllByInventory(inventory, pageable);
    }

    @Override
    public Rate createRate(RateCreateServiceRequestDto requestDto) {
        var rate = Rate.create(
                requestDto.getScore(),
                requestDto.getInventory(),
                requestDto.getUserId());
        return repository.save(rate);
    }

    @Override
    public Rate updateRate(String rateId, RateUpdateServiceRequestDto requestDto) {
        var rate = readRate(rateId);
        return repository.save(rate.setScore(requestDto.getScore()));
    }

    @Override
    public void deleteRate(String id) {
        repository.delete(readRate(id));
    }

    @Override
    public float getAverageRate(Long inventoryId) {
        return Optional.ofNullable(repository.findAverageRate(inventoryId))
                .orElse(0F);
    }

    @Override
    public Optional<Rate> getRateByInventoryAndUser(Long inventoryId, Long userId) {
        return repository.findByInventoryAndUser(inventoryId, userId);
    }
}
