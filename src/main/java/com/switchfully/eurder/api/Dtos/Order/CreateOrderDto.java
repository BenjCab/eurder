package com.switchfully.eurder.api.Dtos.Order;

import java.lang.reflect.Array;
import java.util.List;

public class CreateOrderDto {
    //private final List<CreateItemGroupDTO> itemGroups;
    private CreateItemGroupDTO[] itemGroups;

/*
    public CreateOrderDto(List<CreateItemGroupDTO> itemGroups) {
        this.itemGroups = itemGroups;
    }
    public List<CreateItemGroupDTO> getItemGroups() {
        return itemGroups;
    }*/
/*
    public CreateOrderDto(CreateItemGroupDTO[] itemGroups) {
        this.itemGroups = itemGroups;
    }*/

    public CreateItemGroupDTO[] getItemGroups() {
        return itemGroups;
    }
}
