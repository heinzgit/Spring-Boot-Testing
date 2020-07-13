package com.example.mockito;

import com.example.mockito.dao.ItemRepository;
import com.example.mockito.model.Item;
import com.example.mockito.service.ItemBusinessService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.booleanThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

    @InjectMocks
    ItemBusinessService itemBusinessService;

    @Mock
    ItemRepository itemRepository;

    @Test
    public void testService() {
        when(itemRepository.findAll()).thenReturn(
                Arrays.asList(new Item(1, "Item1", 10, 100),
                        new Item(2, "Item2", 10, 100))
        );

        List<Item> items = itemBusinessService.retieveAllItems();

        assertEquals(1000, items.get(0).getValue());
        assertEquals(1000, items.get(1).getValue());
    }
}
