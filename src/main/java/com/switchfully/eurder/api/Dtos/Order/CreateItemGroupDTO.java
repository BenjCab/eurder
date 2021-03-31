package com.switchfully.eurder.api.Dtos.Order;

import com.switchfully.eurder.domain.Item;

import java.util.UUID;

public class CreateItemGroupDTO {
    private UUID itemID;
    private int amount;
/*
    public CreateItemGroupDTO(UUID itemID, int amount) {
        this.itemID = itemID;
        this.amount = amount;
    }*/

    public UUID getItemID() {
        return itemID;
    }

    public int getAmount() {
        return amount;
    }
}
