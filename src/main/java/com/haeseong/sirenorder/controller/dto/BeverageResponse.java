package com.haeseong.sirenorder.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BeverageResponse {
    private final Integer id;
    private final Integer categoryId;
    private final String name;
    private final Integer price;
    private final String imageUrl;
}
