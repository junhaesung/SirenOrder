package com.haeseong.sirenorder.model.entity;

import com.haeseong.sirenorder.model.Entity;
import lombok.Data;

@Data
public class Category implements Entity<Integer> {
    private Integer id;
    private String name;

    public static Category of(final Integer id, final String name) {
        final Category category = new Category();
        category.id = id;
        category.name = name;
        return category;
    }
}
