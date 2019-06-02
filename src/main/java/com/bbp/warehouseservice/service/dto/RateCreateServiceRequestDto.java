package com.bbp.warehouseservice.service.dto;

import com.bbp.warehouseservice.domain.Inventory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RateCreateServiceRequestDto {

    private float score;

    private Inventory inventory;

    private Long userId;
}
