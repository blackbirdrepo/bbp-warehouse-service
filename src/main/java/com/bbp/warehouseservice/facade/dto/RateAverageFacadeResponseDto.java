package com.bbp.warehouseservice.facade.dto;

import com.bbp.warehouseservice.domain.Inventory;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RateAverageFacadeResponseDto {

    private float score;

    private Inventory inventory;

    public static RateAverageFacadeResponseDto create(float score, Inventory inventory) {
        return new RateAverageFacadeResponseDto()
                .setScore(score)
                .setInventory(inventory);
    }
}
