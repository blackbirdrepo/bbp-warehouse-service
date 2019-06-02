package com.bbp.warehouseservice.service.mapper;

import com.bbp.warehouseservice.domain.Rate;
import com.bbp.warehouseservice.facade.dto.RateAverageFacadeResponseDto;
import com.bbp.warehouseservice.facade.dto.RateCreateUpdateFacadeRequestDto;
import com.bbp.warehouseservice.facade.dto.RateCreateUpdateFacadeRequestDto;
import com.bbp.warehouseservice.rest.dto.RateAverageRestResponseDto;
import com.bbp.warehouseservice.rest.dto.RateCreateUpdateRestRequestDto;
import com.bbp.warehouseservice.rest.dto.RateRestResponseDto;
import com.bbp.warehouseservice.service.dto.RateCreateServiceRequestDto;
import com.bbp.warehouseservice.service.dto.RateUpdateServiceRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface RateMapper {

    RateCreateUpdateFacadeRequestDto toCreateUpdateFacadeRequest(RateCreateUpdateRestRequestDto requestDto);

    RateCreateServiceRequestDto toCreateServiceRequest(RateCreateUpdateFacadeRequestDto requestDto);

    RateUpdateServiceRequestDto toUpdateServiceRequest(RateCreateUpdateFacadeRequestDto requestDto);

    @Mapping(target = "inventoryId", source = "rate.inventory.id")
    @Mapping(target = "userId", source = "rate.user")
    RateRestResponseDto toRestResponse(Rate rate);

    @Mapping(target = "inventoryId", source = "responseDto.inventory.id")
    RateAverageRestResponseDto toAverageRestResponse(RateAverageFacadeResponseDto responseDto);

    default Page<RateRestResponseDto> toRestResponsePage(Page<Rate> ratePage) {
        return ratePage.map(this::toRestResponse);
    }
}
