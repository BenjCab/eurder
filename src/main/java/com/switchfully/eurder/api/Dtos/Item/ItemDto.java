package com.switchfully.eurder.api.Dtos.Item;

public class ItemDto {
    private String name;
    private String description;
    private float price;
    private boolean isInStock;

    public ItemDto(String name, String description, float price, int amountInStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.isInStock = amountInStock>0f;
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
}
