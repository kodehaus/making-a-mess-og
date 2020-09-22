package com.cprime.bonfireevents.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EventControllerTest {

    public static final String basicEventJson = "{ \"title\":\"An event\", \"description\":\"The description\" } ";

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testThatGetWorksAtAll() throws Exception {
        mockMvc.perform(get("/event/0")).andExpect(status().isOk());
}

    @Test
    public void testThatPostReturnsCreated() throws Exception {
        mockMvc.perform(
                    post("/event")
                        .contentType("application/json")
                        .content(basicEventJson)
                )
                .andExpect(status().isCreated());
    }

}
