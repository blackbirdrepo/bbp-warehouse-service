package com.bbp.warehouseservice.rest.controller;



import com.bbp.warehouseservice.facade.InventoryFacade;
import com.bbp.warehouseservice.rest.dto.InventoryCreateUpdateRestRequestDto;
import com.bbp.warehouseservice.rest.dto.InventoryRestResponseDto;
import com.bbp.warehouseservice.service.mapper.InventoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.bbp.warehouseservice.config.Constants.REST_PATH;

@RequiredArgsConstructor
@RestController
@RequestMapping(REST_PATH + "/inventories/")
public class InventoryController {

    private final InventoryFacade facade;
    private final InventoryMapper mapper;

    @GetMapping(path = "{inventoryId}")
    public ResponseEntity<InventoryRestResponseDto> readInventory(@PathVariable String inventoryId) {
        var inventory = facade.readInventory(inventoryId);
        return ResponseEntity.ok().body(mapper.toRestResponse(inventory));
    }

    @GetMapping
    public ResponseEntity<Page<InventoryRestResponseDto>> readInventories(Pageable pageable) {
        var inventories = facade.readInventories(pageable);
        return ResponseEntity.ok().body(mapper.toRestResponsePage(inventories));
    }

    @PostMapping
    public ResponseEntity<InventoryRestResponseDto> createInventory(
            @RequestBody InventoryCreateUpdateRestRequestDto restDto) {
        var facadeDto = mapper.toCreateUpdateFacadeRequest(restDto);
        var inventory = facade.createInventory(facadeDto);
        //TODO fix null in location
        return ResponseEntity.created(null).body(mapper.toRestResponse(inventory));
    }

    @PutMapping(path = "/{inventoryId}")
    public ResponseEntity<InventoryRestResponseDto> updateInventory(
            @PathVariable("inventoryId") String inventoryId,
            @RequestBody InventoryCreateUpdateRestRequestDto restDto) {
        var facadeDto = mapper.toCreateUpdateFacadeRequest(restDto);
        var inventory = facade.updateInventory(inventoryId, facadeDto);
        return ResponseEntity.ok().body(mapper.toRestResponse(inventory));
    }

    @DeleteMapping(path = "/{inventoryId}")
    public ResponseEntity<Void> deleteInventory(@PathVariable String inventoryId) {
        facade.deleteInventory(inventoryId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(path = "/{inventoryId}/quantity/reduce")
    public ResponseEntity<Void> deleteInventory(@PathVariable String inventoryId,
                                                @RequestParam("amount") int amount) {
        facade.reduceInventoryQuantity(inventoryId, amount);
        return ResponseEntity.noContent().build();
    }
}
