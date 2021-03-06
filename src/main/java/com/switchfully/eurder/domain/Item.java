package com.switchfully.eurder.domain;

import com.switchfully.eurder.infrastructure.utils.ValidationUtil;

import java.util.UUID;

public class Item {
    private final UUID uuid;
    private final String name;
    private final String description;
    private final float price;
    private final int amountInStock;

    public Item(UUID id,String name, String description, Float price, Integer amountInStock) {
        ValidationUtil.throwExceptionIfNull(name,"name");
        ValidationUtil.throwExceptionIfNull(description,"description");
        if (price==null || price ==0){
            throw new IllegalArgumentException("Price cannot be null or equal to 0.");
        }
        if(amountInStock==null){
            throw new IllegalArgumentException("The amount in stock cannot be null, a value must be supplied, even if 0.");
        }
        this.name = name;
        this.description = description;
        this.price = price;
        this.amountInStock = amountInStock;
        uuid = id;
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

    public UUID getUuid() {
        return uuid;
    }
}
