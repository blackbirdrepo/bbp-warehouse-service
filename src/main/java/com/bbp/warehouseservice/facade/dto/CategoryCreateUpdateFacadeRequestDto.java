package com.bbp.warehouseservice.facade.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryCreateUpdateFacadeRequestDto {

    private String name;

    private String parentId;
}
