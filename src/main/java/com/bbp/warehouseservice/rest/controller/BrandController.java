package com.bbp.warehouseservice.rest.controller;

import com.bbp.warehouseservice.facade.BrandFacade;
import com.bbp.warehouseservice.rest.dto.BrandCreateUpdateRestRequestDto;
import com.bbp.warehouseservice.rest.dto.BrandRestResponseDto;
import com.bbp.warehouseservice.service.mapper.BrandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.bbp.warehouseservice.config.Constants.REST_PATH;

@RequiredArgsConstructor
@RestController
@RequestMapping(REST_PATH + "/brands/")
public class BrandController {

    private final BrandFacade facade;
    private final BrandMapper mapper;

    @GetMapping(path = "{brandId}")
    public ResponseEntity<BrandRestResponseDto> readBrand(@PathVariable String brandId) {
        var brand = facade.readBrand(brandId);
        return ResponseEntity.ok().body(mapper.toRestResponse(brand));
    }

    @GetMapping
    public ResponseEntity<Page<BrandRestResponseDto>> readBrand(Pageable pageable) {
        var inventories = facade.readBrand(pageable);
        return ResponseEntity.ok().body(mapper.toRestResponsePage(inventories));
    }

    @PostMapping
    public ResponseEntity<BrandRestResponseDto> createBrand(
            @RequestBody BrandCreateUpdateRestRequestDto restDto) {
        var facadeDto = mapper.toCreateUpdateFacadeRequest(restDto);
        var brand = facade.createBrand(facadeDto);
        //TODO fix null in location
        return ResponseEntity.created(null).body(mapper.toRestResponse(brand));
    }

    @PutMapping(path = "/{brandId}")
    public ResponseEntity<BrandRestResponseDto> createBrand(
            @PathVariable("brandId") String brandId,
            @RequestBody BrandCreateUpdateRestRequestDto restDto) {
        var facadeDto = mapper.toCreateUpdateFacadeRequest(restDto);
        var brand = facade.updateBrand(brandId, facadeDto);
        return ResponseEntity.ok().body(mapper.toRestResponse(brand));
    }

    @DeleteMapping(path = "/{brandId}")
    public ResponseEntity<Void> deleteBrand(@PathVariable String brandId) {
        facade.deleteBrand(brandId);
        return ResponseEntity.noContent().build();
    }
}