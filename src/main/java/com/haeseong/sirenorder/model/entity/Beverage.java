package com.haeseong.sirenorder.model.entity;

import com.haeseong.sirenorder.model.Entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Beverage implements Entity<Integer> {
    /**
     * 음료 아이디
     */
    private Integer id;
    /**
     * 카테고리 아이디
     */
    private Integer categoryId;
    /**
     * 이름
     */
    private String name;
    /**
     * 가격
     */
    private Integer price;
    /**
     * 이미지 주소
     */
    private String imageUrl;
}
