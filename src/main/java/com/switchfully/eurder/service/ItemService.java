package com.switchfully.eurder.service;

import com.switchfully.eurder.domain.Item;
import com.switchfully.eurder.domain.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository){
        this.itemRepository=itemRepository;
    }

    public void addNewItem(Item item){
        itemRepository.addNewItem(item);
    }

    //it wasnt asked to get all the items, but this method is useful for testing/debugging/etc
    public List<Item> getItems(){
        return itemRepository.getItems();
    }

    public boolean doesItemExist(UUID id) {
        return itemRepository.doesItemExist(id);
    }

    public void updateItem(Item item) {
        itemRepository.updateItem(item);
    }
    /*
    public boolean doesItemExist(UUID id) {
        return itemRepository.doesItemExist(id);
    }*/

}
