package com.switchfully.eurder.api.Dtos.Item;

import com.switchfully.eurder.domain.Item;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ItemMapper {
    /*
    private final ItemService itemService;

    public ItemMapper(ItemService itemService) {
        this.itemService = itemService;
    }
*/
    public List<ItemDto> mapToDtoList(List<Item> items) {
        return items.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    private ItemDto mapToDto(Item item) {
        return new ItemDto(item.getName(), item.getDescription(), item.getPrice(), item.getAmountInStock(), item.getUuid());
    }

    public Item mapCreateItemDTOToItem(CreateItemDTO createItemDTO, UUID id) {
        return new Item(id,createItemDTO.getName(), createItemDTO.getDescription(), createItemDTO.getPrice(), createItemDTO.getAmountInStock());
    }

    public List<ItemSupplyDto> mapToDtoListOfItemsSupply(List<Item> items) {
        return items.stream().map(this::mapToSupplyDto).collect(Collectors.toList());
    }

    private ItemSupplyDto mapToSupplyDto(Item item) {
        return new ItemSupplyDto(item.getName(), item.getDescription(), item.getPrice(), item.getAmountInStock(), item.getUuid());
    }
}
