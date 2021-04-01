package com.switchfully.eurder.api.Dtos.Order;

import java.lang.reflect.Array;
import java.util.List;

public class CreateOrderDto {
    private CreateItemGroupDTO[] itemGroups;

    public CreateItemGroupDTO[] getItemGroups() {
        return itemGroups;
    }
}
