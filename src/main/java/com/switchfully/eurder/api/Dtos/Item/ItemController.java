package com.switchfully.eurder.api.Dtos.Item;

import com.switchfully.eurder.infrastructure.utils.ValidationUtil;
import com.switchfully.eurder.service.CustomerService;
import com.switchfully.eurder.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/items")
public class ItemController {
    private final ItemService itemService;
    private final ItemMapper itemMapper;
    private final CustomerService customerService;
    final static Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    public ItemController(ItemService itemService, ItemMapper itemMapper, CustomerService customerService) {
        this.itemService = itemService;
        this.itemMapper = itemMapper;
        this.customerService = customerService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDto> getItems() {
        logger.info("Received a request to display all items");
        return itemMapper.mapToDtoList(itemService.getItems());
    }

    @GetMapping(path = "/{levelOfSupply}")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemSupplyDto> getItemsSupply(@RequestHeader("Authorization") String userId,@PathVariable String levelOfSupply) {
        logger.info("Received a request to display items supply by "+userId);
        ValidationUtil.hasAdminRights(userId,customerService);

        return itemMapper.mapToDtoListOfItemsSupply(itemService.getItemsWithLevelOfSupply(levelOfSupply));
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createItem(@RequestBody CreateItemDTO createItemDTO, @RequestHeader("Authorization") String userId) {
        logger.info("Received a request to create an item with name : "+createItemDTO.getName()+" from : "+userId);
        ValidationUtil.hasAdminRights(userId, customerService);
        itemService.addNewItem(itemMapper.mapCreateItemDTOToItem(createItemDTO));
    }

    @PutMapping(path = "/{idOfItem}", consumes = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateItem(@RequestBody CreateItemDTO createItemDTO, @PathVariable String idOfItem, @RequestHeader("Authorization") String idOfUser) {
        logger.info("Received a request to update an item with id : "+idOfItem+" from : "+idOfUser);
        ValidationUtil.hasAdminRights(idOfUser,customerService);
        ValidationUtil.doesItemExist(idOfItem,itemService);
        itemService.updateItem(itemMapper.mapCreateItemDTOToItem(createItemDTO), UUID.fromString(idOfItem));
    }
}
