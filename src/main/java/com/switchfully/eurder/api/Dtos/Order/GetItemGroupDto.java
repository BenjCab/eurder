package com.switchfully.eurder.api.Dtos.Order;

public class GetItemGroupDto {
    private final String name;
    private final int orderedAmount;
    private final float totalPrice;

    public GetItemGroupDto(String name, int orderedAmount, float totalPrice) {
        this.name = name;
        this.orderedAmount = orderedAmount;
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public int getOrderedAmount() {
        return orderedAmount;
    }

    public float getTotalPrice() {
        return totalPrice;
    }
}
