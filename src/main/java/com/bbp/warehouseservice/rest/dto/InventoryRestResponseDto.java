package com.bbp.warehouseservice.rest.dto;

import com.bbp.warehouseservice.domain.Brand;
import com.bbp.warehouseservice.domain.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class InventoryRestResponseDto {

    private String id;

    private String sku;

    private String name;

    private String model;

    private String price;

    private int quantity;

    private String brandId;

    private String categoryId;
}
