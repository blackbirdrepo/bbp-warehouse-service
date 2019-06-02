package com.bbp.warehouseservice.rest.controller;

import com.bbp.warehouseservice.facade.CategoryFacade;
import com.bbp.warehouseservice.rest.dto.CategoryCreateUpdateRestRequestDto;
import com.bbp.warehouseservice.rest.dto.CategoryRestResponseDto;
import com.bbp.warehouseservice.service.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.bbp.warehouseservice.config.Constants.REST_PATH;

@RequiredArgsConstructor
@RestController
@RequestMapping(REST_PATH + "/categories/")
public class CategoryController {

    private final CategoryFacade facade;
    private final CategoryMapper mapper;

    @GetMapping(path = "{categoryId}")
    public ResponseEntity<CategoryRestResponseDto> readInventories(@PathVariable String categoryId) {
        var category = facade.readCategory(categoryId);
        return ResponseEntity.ok().body(mapper.toRestResponse(category));
    }

    @GetMapping
    public ResponseEntity<Page<CategoryRestResponseDto>> readCategories(Pageable pageable) {
        var categories = facade.readCategories(pageable);
        return ResponseEntity.ok().body(mapper.toRestResponsePage(categories));
    }

    @PostMapping
    public ResponseEntity<CategoryRestResponseDto> createCategory(
            @RequestBody CategoryCreateUpdateRestRequestDto restDto) {
        var facadeDto = mapper.toCreateUpdateFacadeRequest(restDto);
        var category = facade.createCategory(facadeDto);
        //TODO fix null in location
        return ResponseEntity.created(null).body(mapper.toRestResponse(category));
    }

    @PutMapping(path = "/{categoryId}")
    public ResponseEntity<CategoryRestResponseDto> updateCategory(
            @PathVariable("categoryId") String categoryId,
            @RequestBody CategoryCreateUpdateRestRequestDto restDto) {
        var facadeDto = mapper.toCreateUpdateFacadeRequest(restDto);
        var category = facade.updateCategory(categoryId, facadeDto);
        return ResponseEntity.ok().body(mapper.toRestResponse(category));
    }

    @DeleteMapping(path = "/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable String categoryId) {
        facade.deleteCategory(categoryId);
        return ResponseEntity.noContent().build();
    }
}