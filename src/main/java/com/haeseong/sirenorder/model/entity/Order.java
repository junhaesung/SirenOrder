package com.haeseong.sirenorder.model.entity;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private Member member;
    private List<OrderItem> orderItems;

    public int getTotalPrice() {
        return (int) orderItems.stream()
                .map(OrderItem::getPrice)
                .count();
    }
}
