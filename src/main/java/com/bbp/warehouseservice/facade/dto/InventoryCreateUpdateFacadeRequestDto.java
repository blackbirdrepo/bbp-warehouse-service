package com.bbp.warehouseservice.facade.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class InventoryCreateUpdateFacadeRequestDto {

    private String sku;

    private String name;

    private String model;

    private BigDecimal price;

    private int quantity;

    private String brandId;

    private String categoryId;
}
