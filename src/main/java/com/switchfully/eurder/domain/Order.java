package com.switchfully.eurder.domain;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Order {
    private final List<ItemGroup> itemGroups;
    private float totalPrice=0;
    private final UUID uuid;

    public Order(List<ItemGroup> itemGroups) {
        this.itemGroups = itemGroups;
        for (ItemGroup itemGroup : itemGroups){
            totalPrice+=itemGroup.getPrice();
        }
        uuid = UUID.randomUUID();
    }

    public List<ItemGroup> getItemGroups() {
        return itemGroups;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public UUID getUuid() {
        return uuid;
    }
}
