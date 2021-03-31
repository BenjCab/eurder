package com.switchfully.eurder.domain;

import java.time.LocalDate;
import java.util.UUID;

public class ItemGroup {
    private final String name;
    private final Item item;
    private final int amount;
    private final LocalDate shippingDate;
    private final float price;

    public ItemGroup(Item item, int amount) {
        this.name = item.getName();
        this.item = new Item(UUID.randomUUID(),item.getName(),item.getDescription(),item.getPrice(),item.getAmountInStock());
        this.amount = amount;
        if(item.getAmountInStock()>amount){
            shippingDate= LocalDate.now().plusDays(1);
        }else{
            shippingDate= LocalDate.now().plusDays(7);
        }
        price = this.item.getPrice()*amount;
    }

    public float getPrice() {
        return price;
    }

    public Item getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public String getName() {
        return name;
    }
}
