package com.example.mockito.controller;

import com.example.mockito.model.Item;
import com.example.mockito.service.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService itemBusinessService;

    @GetMapping("/dummy-item")
    public Item dummyItem() {

        return new Item(1, "Ball", 10, 100);

    }

    @GetMapping("/item-business")
    public Item dummyItemBusiness() {

        return itemBusinessService.retrieveHardcodedItem();

    }
}
