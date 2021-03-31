package com.switchfully.eurder.api.Dtos.Order;

import java.util.List;

public class CreateOrderDto {
    private final List<CreateItemGroupDTO> itemGroups;


    public CreateOrderDto(List<CreateItemGroupDTO> itemGroups) {
        this.itemGroups = itemGroups;
    }

    public List<CreateItemGroupDTO> getItemGroups() {
        return itemGroups;
    }
}
