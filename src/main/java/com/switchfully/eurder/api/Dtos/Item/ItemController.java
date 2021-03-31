package com.switchfully.eurder.api.Dtos.Item;

import com.switchfully.eurder.infrastructure.utils.ValidationUtil;
import com.switchfully.eurder.service.CustomerService;
import com.switchfully.eurder.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/items")
public class ItemController {
    private final ItemService itemService;
    private final ItemMapper itemMapper;
    private final CustomerService customerService;

    @Autowired
    public ItemController(ItemService itemService, ItemMapper itemMapper, CustomerService customerService) {
        this.itemService = itemService;
        this.itemMapper = itemMapper;
        this.customerService = customerService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDto> getItems() {
        return itemMapper.mapToDtoList(itemService.getItems());
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createItem(@RequestBody CreateItemDTO createItemDTO, @RequestHeader("Authorization") String userId) {
        ValidationUtil.hasAdminRights(userId, customerService);
        itemService.addNewItem(itemMapper.mapCreateItemDTOToItem(createItemDTO));
    }

    @PutMapping(path = "/{idOfItem}", consumes = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateItem(@RequestBody CreateItemDTO createItemDTO, @PathVariable String idOfItem, @RequestHeader("Authorization") String idOfUser) {
        ValidationUtil.hasAdminRights(idOfUser,customerService);
        ValidationUtil.doesItemExist(idOfItem,itemService);
        itemService.updateItem(itemMapper.mapCreateItemDTOToItem(createItemDTO));
    }
}
