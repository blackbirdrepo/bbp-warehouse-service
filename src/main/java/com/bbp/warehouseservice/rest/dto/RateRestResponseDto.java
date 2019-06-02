package com.bbp.warehouseservice.rest.dto;

import com.bbp.warehouseservice.domain.Inventory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
public class RateRestResponseDto {

    private String id;

    private float score;

    private String inventoryId;

    private String userId;
}
