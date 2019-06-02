package com.bbp.warehouseservice.rest.dto;

import com.bbp.warehouseservice.domain.Brand;
import com.bbp.warehouseservice.domain.Category;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class InventoryCreateUpdateRestRequestDto {

    private String sku;

    private String name;

    private String model;

    private BigDecimal price;

    private int quantity;

    private String brandId;

    private String categoryId;
}
