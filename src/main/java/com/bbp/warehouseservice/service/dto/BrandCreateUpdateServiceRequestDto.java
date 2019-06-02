package com.bbp.warehouseservice.service.dto;

import com.bbp.warehouseservice.domain.enums.CountryEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BrandCreateUpdateServiceRequestDto {

    private String name;

    private String country;

    private boolean premium;
}