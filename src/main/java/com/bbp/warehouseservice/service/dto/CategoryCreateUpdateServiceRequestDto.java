package com.bbp.warehouseservice.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryCreateUpdateServiceRequestDto {

    private String name;

    private String parentId;
}
