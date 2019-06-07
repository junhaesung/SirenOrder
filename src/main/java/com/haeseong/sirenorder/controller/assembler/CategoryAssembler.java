package com.haeseong.sirenorder.controller.assembler;

import com.haeseong.sirenorder.controller.dto.CategoryResponse;
import com.haeseong.sirenorder.model.entity.Category;

public class CategoryAssembler {
    public CategoryResponse assmble(final Category category) {
        return CategoryResponse.of(
                category.getId(),
                category.getName()
        );
    }
}
