package com.haeseong.sirenorder.controller.dto;

import lombok.Data;

@Data(staticConstructor = "of")
public class CategoryResponse {
    private final Integer id;
    private final String name;
}
