package com.bbp.warehouseservice.rest.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
public class RateAverageRestResponseDto {

    private float score;

    private String inventoryId;
}
