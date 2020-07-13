package com.example.mockito.service;

import com.example.mockito.dao.ItemRepository;
import com.example.mockito.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBusinessService {

    @Autowired
    private ItemRepository itemRepository;

    public Item retrieveHardcodedItem() {
        return new Item(2, "Ball2", 100, 1000);
    }

    public List<Item> retieveAllItems() {
        List<Item> items = itemRepository.findAll();
        for (Item item: items) {
            item.setValue(item.getPrice() * item.getQuality());
        }
        return items;
    }
}
