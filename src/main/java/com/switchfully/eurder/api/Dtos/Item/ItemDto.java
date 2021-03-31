package com.switchfully.eurder.api.Dtos.Item;

import java.util.UUID;

public class ItemDto {
    private String name;
    private String description;
    private float price;
    private boolean isInStock;
    private UUID id;

    public ItemDto(String name, String description, float price, int amountInStock, UUID id) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.isInStock = amountInStock>0f;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public boolean isInStock() {
        return isInStock;
    }

    public UUID getId() {
        return id;
    }
}
