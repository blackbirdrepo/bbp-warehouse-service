package com.bbp.warehouseservice.service.mapper;

import com.bbp.warehouseservice.domain.Inventory;
import com.bbp.warehouseservice.facade.dto.InventoryCreateUpdateFacadeRequestDto;
import com.bbp.warehouseservice.rest.dto.InventoryCreateUpdateRestRequestDto;
import com.bbp.warehouseservice.rest.dto.InventoryRestResponseDto;
import com.bbp.warehouseservice.service.dto.InventoryCreateUpdateServiceRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface InventoryMapper {

    InventoryCreateUpdateFacadeRequestDto toCreateUpdateFacadeRequest(InventoryCreateUpdateRestRequestDto requestDto);

    InventoryCreateUpdateServiceRequestDto toCreateUpdateServiceRequest(InventoryCreateUpdateFacadeRequestDto requestDto);

    @Mapping(target = "categoryId", source = "inventory.category.id")
    @Mapping(target = "brandId", source = "inventory.brand.id")
    InventoryRestResponseDto toRestResponse(Inventory inventory);

    default Page<InventoryRestResponseDto> toRestResponsePage(Page<Inventory> inventoryPage) {
        return inventoryPage.map(this::toRestResponse);
    }
}
