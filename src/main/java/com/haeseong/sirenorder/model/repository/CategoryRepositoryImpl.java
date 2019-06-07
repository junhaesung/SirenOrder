package com.haeseong.sirenorder.model.repository;

import com.haeseong.sirenorder.model.entity.Category;

import java.util.Arrays;
import java.util.List;

public class CategoryRepositoryImpl extends AbstractInmemoryRepository<Category, Integer> implements CategoryRepository {
    public CategoryRepositoryImpl() {
        // 기본 데이터 추가
        final List<Category> baseCategories = Arrays.asList(
                Category.of(1, "Espresso"),
                Category.of(2, "Decaffeinated")
        );
        baseCategories.forEach(category -> map.put(category.getId(), category));
    }
}
