package com.switchfully.eurder.api.Dtos.Item;

import java.util.UUID;

public class ItemSupplyDto extends ItemDto{
    private final int stockAmount;

    public ItemSupplyDto(String name, String description, float price, int amountInStock, UUID id) {
        super(name, description, price, amountInStock, id);
        stockAmount = amountInStock;
    }

    public int getStockAmount() {
        return stockAmount;
    }
}
