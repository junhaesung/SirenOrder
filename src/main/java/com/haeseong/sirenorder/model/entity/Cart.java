package com.haeseong.sirenorder.model.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * 장바구니
 */
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString(exclude = "member")
public class Cart {
    private final Member member;
    private final List<Beverage> beverages;

    public static Cart from(final Member member) {
        return new Cart(member, new ArrayList<>());
    }
}
