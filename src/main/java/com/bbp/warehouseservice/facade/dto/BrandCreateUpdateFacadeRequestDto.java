package com.bbp.warehouseservice.facade.dto;

import com.bbp.warehouseservice.domain.enums.CountryEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
public class BrandCreateUpdateFacadeRequestDto {

    private String name;

    private String country;

    private boolean premium;
}
