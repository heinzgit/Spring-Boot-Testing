package com.example.mockito.service;

import com.example.mockito.model.Item;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ItemBusinessService {

    public Item retrieveHardcodedItem() {
        return new Item(2, "Ball2", 100, 1000);
    }
}
