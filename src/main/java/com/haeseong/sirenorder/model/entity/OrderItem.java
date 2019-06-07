package com.haeseong.sirenorder.model.entity;

import lombok.Data;

import java.util.List;

@Data
public class OrderItem {
    private Beverage beverage;
    private List<BeverageOption> beverageOptions;

    public int getPrice() {
        final int priceOfBeverage = beverage.getPrice();
        final int priceOfOptions = (int) beverageOptions.stream()
                .map(BeverageOption::getPrice)
                .count();
        return priceOfBeverage + priceOfOptions;
    }
}
