package com.haeseong.sirenorder.controller.assembler;

import com.haeseong.sirenorder.controller.dto.BeverageResponse;
import com.haeseong.sirenorder.model.entity.Beverage;

public class BeverageAssembler {
    public BeverageResponse assemble(final Beverage beverage) {
        return BeverageResponse.builder()
                .id(beverage.getId())
                .categoryId(beverage.getCategoryId())
                .name(beverage.getName())
                .price(beverage.getPrice())
                .imageUrl(beverage.getImageUrl())
                .build();
    }
}
