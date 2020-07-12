package com.example.mockito;

import com.example.mockito.controller.HelloWorldController;
import com.example.mockito.controller.ItemController;
import com.example.mockito.model.Item;
import com.example.mockito.service.ItemBusinessService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService businessService;

    @Test
    public void testController() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quality\":100}"))
                .andReturn();
//        assertEquals("Hello World", result.getResponse().getContentAsString());
    }

    @Test
    public void testController1() throws Exception {

        when(businessService.retrieveHardcodedItem()).thenReturn(new Item(2, "Ball2", 100, 1000));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-business")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\": 2,\"name\":\"Ball2\",\"price\":100,\"quality\":1000}"))
                .andReturn();
//        assertEquals("Hello World", result.getResponse().getContentAsString());
    }
}
