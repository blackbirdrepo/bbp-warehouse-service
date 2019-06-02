package com.bbp.warehouseservice.facade.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@NoArgsConstructor
public class RateCreateUpdateFacadeRequestDto {

    @Range(max = 5)
    private float score;
}
