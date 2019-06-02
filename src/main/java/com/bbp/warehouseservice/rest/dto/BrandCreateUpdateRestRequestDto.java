package com.bbp.warehouseservice.rest.dto;

import com.bbp.warehouseservice.domain.enums.CountryEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BrandCreateUpdateRestRequestDto {

    private String name;

    private String country;

    private boolean premium;
}
