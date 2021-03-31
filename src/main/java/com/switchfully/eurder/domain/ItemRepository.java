package com.switchfully.eurder.domain;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ItemRepository {
    private final Map<UUID,Item> itemDatabase;

    public ItemRepository() {
        this.itemDatabase = new HashMap<>();

        //hardcode list of items just for the exercice

        Item i1 = new Item(UUID.randomUUID(),"mousepad","a beautiful mousepad",5f,80);
        Item i2 = new Item(UUID.randomUUID(),"Screen H2L4","a large screen",505f,10);
        Item i3 = new Item(UUID.randomUUID(),"Lamp","a beautiful lamp",9f,60);
        Item i4 = new Item(UUID.randomUUID(),"Hdmi cable","a useful cable",6f,880);
        itemDatabase.put(i1.getUuid(),i1);
        itemDatabase.put(i2.getUuid(),i2);
        itemDatabase.put(i3.getUuid(),i3);
        itemDatabase.put(i4.getUuid(),i4);
    }

    public List<Item> getItems() {
        return new ArrayList<>(itemDatabase.values());
    }

    public void addNewItem(Item item){
        itemDatabase.put(item.getUuid(),item);
    }

    public boolean doesItemExist(UUID id) {
        return itemDatabase.containsKey(id);
    }

    public void updateItem(Item item,UUID id) {
        itemDatabase.remove(id);
        itemDatabase.put(item.getUuid(),item);
    }
    public Item getItemFromId(UUID id){
        return itemDatabase.get(id);
    }

    /*
    public boolean doesItemExist(UUID id) {
        return itemDatabase.containsKey(id);
    }*/
}
