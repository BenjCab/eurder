package com.switchfully.eurder.api.Dtos.Order;

import java.util.List;
import java.util.UUID;

public class GetOrderDto {
    private final UUID id;
    private final float totalPrice;
    private final List<GetItemGroupDto> itemGroups;

    public GetOrderDto(UUID id, float totalPrice, List<GetItemGroupDto> itemGroups) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.itemGroups = itemGroups;
    }

    public UUID getId() {
        return id;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public List<GetItemGroupDto> getItemGroups() {
        return itemGroups;
    }
}
