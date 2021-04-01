package com.switchfully.eurder.service;

import com.switchfully.eurder.domain.Item;
import com.switchfully.eurder.domain.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void addNewItem(Item item) {
        itemRepository.addNewItem(item);
    }

    //it wasnt asked to get all the items, but this method is useful for testing/debugging/etc
    public List<Item> getItems() {
        return itemRepository.getItems();
    }
    public ItemRepository getItemRepository() {
        return itemRepository;
    }

    public boolean doesItemExist(UUID id) {
        return itemRepository.doesItemExist(id);
    }

    public void updateItem(Item item, UUID id) {
        itemRepository.updateItem(item, id);
    }

    public List<Item> getItemsWithLevelOfSupply(String levelOfSupply) {
        if (levelOfSupply.equals("STOCK_LOW")) {
            return itemRepository.getItems().stream().filter(item -> item.getAmountInStock() < 5).collect(Collectors.toList());
        }
        if (levelOfSupply.equals("STOCK_MEDIUM")) {
            return itemRepository.getItems().stream().filter(item -> item.getAmountInStock() < 10).collect(Collectors.toList());
        }
        if (levelOfSupply.equals("STOCK_HIGH")) {
            return itemRepository.getItems().stream().filter(item -> item.getAmountInStock() >= 10).collect(Collectors.toList());
        }
        return itemRepository.getItems();
    }
    /*
    public boolean doesItemExist(UUID id) {
        return itemRepository.doesItemExist(id);
    }*/

}
