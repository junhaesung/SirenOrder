package com.haeseong.sirenorder.controller;

import com.haeseong.sirenorder.controller.assembler.BeverageAssembler;
import com.haeseong.sirenorder.controller.assembler.CategoryAssembler;
import com.haeseong.sirenorder.controller.dto.BeverageResponse;
import com.haeseong.sirenorder.controller.dto.CategoryResponse;
import com.haeseong.sirenorder.model.service.BeverageService;
import com.haeseong.sirenorder.model.service.CategoryService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class MenuController {
    private final CategoryService categoryService;
    private final BeverageService beverageService;
    private final CategoryAssembler categoryAssembler;
    private final BeverageAssembler beverageAssembler;

    public List<CategoryResponse> getCategories() {
        return categoryService.getCategories().stream()
                .map(categoryAssembler::assmble)
                .collect(Collectors.toList());
    }

    public List<BeverageResponse> getBeverages() {
        return beverageService.getBeverages().stream()
                .map(beverageAssembler::assemble)
                .collect(Collectors.toList());
    }
}
