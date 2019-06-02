package com.bbp.warehouseservice.rest.controller;

import com.bbp.warehouseservice.facade.RateFacade;
import com.bbp.warehouseservice.rest.dto.RateAverageRestResponseDto;
import com.bbp.warehouseservice.rest.dto.RateCreateUpdateRestRequestDto;
import com.bbp.warehouseservice.rest.dto.RateRestResponseDto;
import com.bbp.warehouseservice.service.mapper.RateMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.bbp.warehouseservice.config.Constants.REST_PATH;

@RequiredArgsConstructor
@RestController
@RequestMapping(REST_PATH)
public class RateController {

    private final RateFacade facade;
    private final RateMapper mapper;

    @GetMapping(path = "/inventories/{inventoryId}/rates/{rateId}")
    public ResponseEntity<RateRestResponseDto> readRate(@PathVariable("inventoryId") String inventoryId,
                                                        @PathVariable("rateId") String rateId) {
        var rate = facade.readRate(inventoryId, rateId);
        return ResponseEntity.ok().body(mapper.toRestResponse(rate));
    }

    @GetMapping(path = "/inventories/{inventoryId}/rates/")
    public ResponseEntity<Page<RateRestResponseDto>> readRate(@PathVariable("inventoryId") String inventoryId,
                                                              Pageable pageable) {
        var inventories = facade.readRates(inventoryId, pageable);
        return ResponseEntity.ok().body(mapper.toRestResponsePage(inventories));
    }

    @PostMapping("/inventories/{inventoryId}/rates/")
    public ResponseEntity<RateRestResponseDto> createRate(@PathVariable("inventoryId") String inventoryId,
                                                          @RequestBody RateCreateUpdateRestRequestDto restDto) {
        var facadeDto = mapper.toCreateUpdateFacadeRequest(restDto);
        var rate = facade.createRate(inventoryId, facadeDto);
        //TODO fix null in response URL
        return ResponseEntity.created(null).body(mapper.toRestResponse(rate));
    }

    @PutMapping(path = "/inventories/{inventoryId}/rates/{rateId}")
    public ResponseEntity<RateRestResponseDto> updateRate(@PathVariable("inventoryId") String inventoryId,
                                                          @PathVariable("rateId") String rateId,
                                                          @RequestBody RateCreateUpdateRestRequestDto restDto) {
        var facadeDto = mapper.toCreateUpdateFacadeRequest(restDto);
        var rate = facade.updateRate(inventoryId, rateId, facadeDto);
        return ResponseEntity.ok().body(mapper.toRestResponse(rate));
    }

    @DeleteMapping(path = "/inventories/{inventoryId}/rates/{rateId}")
    public ResponseEntity<Void> deleteRate(@PathVariable("inventoryId") String inventoryId,
                                           @PathVariable("rateId") String rateId) {
        facade.deleteRate(inventoryId, rateId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/inventories/{inventoryId}/average/rates/")
    public ResponseEntity<RateAverageRestResponseDto> readRate(@PathVariable("inventoryId") String inventoryId) {
        var averageRateResponse = facade.getAverageRate(inventoryId);
        return ResponseEntity.ok().body(mapper.toAverageRestResponse(averageRateResponse));
    }
}