package com.switchfully.eurder.api.Dtos.Order;

import com.switchfully.eurder.domain.ItemGroup;
import com.switchfully.eurder.domain.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {
    private final ItemGroupMapper itemGroupMapper;

    public OrderMapper(ItemGroupMapper itemGroupMapper) {
        this.itemGroupMapper = itemGroupMapper;
    }

    public Order mapCreateOrderDtoToOrder(CreateOrderDto createOrderDto) {
        ArrayList<ItemGroup> itemGroupList = new ArrayList<>();
        for (CreateItemGroupDTO itemGroupDto : createOrderDto.getItemGroups()){
            itemGroupList.add(new ItemGroup(itemGroupDto.getItem(),itemGroupDto.getAmount()));
        }
        return new Order(itemGroupList);
    }

    public GetOrderDto mapOrderToGetOrderDto (Order order){
        List<GetItemGroupDto> getItemGroupDtosList = new ArrayList<>();
        for (ItemGroup itemGroup : order.getItemGroups()){
            getItemGroupDtosList.add(itemGroupMapper.mapItemGroupToGetItemGroupDto(itemGroup));
        }
        return new GetOrderDto(order.getUuid(),order.getTotalPrice(),getItemGroupDtosList);
    }

    public List<GetOrderDto> mapListOrderToListGetOrderDto (List<Order> list){
        return list.stream().map(this::mapOrderToGetOrderDto).collect(Collectors.toList());
    }
}
