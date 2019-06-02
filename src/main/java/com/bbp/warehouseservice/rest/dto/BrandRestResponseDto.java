package com.bbp.warehouseservice.rest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;

@Getter
@Setter
@NoArgsConstructor
public class BrandRestResponseDto {

    private Long id;

    private String name;

    private String country;

    private boolean premium;
}
