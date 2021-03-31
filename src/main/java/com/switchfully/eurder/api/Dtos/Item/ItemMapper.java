package com.switchfully.eurder.api.Dtos.Item;

import com.switchfully.eurder.domain.Item;
import org.springframework.stereotype.Component;

import java.util.List;
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
        return new ItemDto(item.getName(), item.getDescription(), item.getPrice(), item.getAmountInStock());
    }

    public Item mapCreateItemDTOToItem(CreateItemDTO createItemDTO) {
        return new Item(createItemDTO.getName(), createItemDTO.getDescription(), createItemDTO.getPrice(), createItemDTO.getAmountInStock());
    }
}
