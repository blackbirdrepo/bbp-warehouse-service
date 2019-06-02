package com.bbp.warehouseservice.service.dto;

import com.bbp.warehouseservice.domain.Brand;
import com.bbp.warehouseservice.domain.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@NoArgsConstructor
public class InventoryCreateUpdateServiceRequestDto {

    private String sku;

    private String name;

    private String model;

    private BigDecimal price;

    private int quantity;

    private Brand brand;

    private Category category;
}
