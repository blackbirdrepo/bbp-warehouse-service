package com.bbp.warehouseservice.rest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryCreateUpdateRestRequestDto {

    private String name;

    private String parentId;
}
