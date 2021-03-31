package com.switchfully.eurder.api.Dtos.Item;

public class CreateItemDTO {
    private String name;
    private String description;
    private float price;
    private int amountInStock;

    public CreateItemDTO(String name, String description, float price, int amountInStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amountInStock = amountInStock;
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

    public int getAmountInStock() {
        return amountInStock;
    }
}
