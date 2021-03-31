package com.switchfully.eurder.api.Dtos.Order;

import com.switchfully.eurder.domain.ItemGroup;
import org.springframework.stereotype.Component;

@Component
public class ItemGroupMapper {
    public GetItemGroupDto mapItemGroupToGetItemGroupDto(ItemGroup itemGroup){
        return new GetItemGroupDto(itemGroup.getName(),itemGroup.getAmount(),itemGroup.getPrice());
    }
}
