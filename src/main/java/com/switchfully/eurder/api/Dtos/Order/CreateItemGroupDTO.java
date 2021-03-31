package com.switchfully.eurder.api.Dtos.Order;

import com.switchfully.eurder.domain.Item;

public class CreateItemGroupDTO {
    private final Item item;
    private final int amount;

    public CreateItemGroupDTO(Item item, int amount) {
        this.item = item;
        this.amount = amount;
    }

    public Item getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }
}
