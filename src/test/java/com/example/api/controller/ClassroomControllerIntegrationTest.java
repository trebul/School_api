package com.example.api.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ClassroomControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    private AuthHelper authHelper;

    private String token;
    @BeforeEach
    void setUp() throws Exception {
        authHelper = new AuthHelper(mockMvc);
        token = authHelper.obtainAccessToken("lmaocháč", "cze");
    }
    @Test
    void getAllClassrooms() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/classroom")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + token))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    void shouldReturnSpecificClassroom() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/classroom/{id}", 3)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + token))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Math 101"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.year").value(2023))
                .andExpect(MockMvcResultMatchers.jsonPath("$.floor").value(2));
    }

    @Test
    void createClassroom() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/classroom")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + token)
                        .content("{\"name\": \"čeština 303\", \"year\": 2025, \"floor\": 3, \"teacher\": { \"firstname\": \"Jindra\", \"lastname\": \"Mandík\", \"age\": 50, \"salary\": 55000}, \"student\": [{\"firstname\": \"Alice\", \"lastname\": \"Smith\", \"age\": 16, \"address\": {\"city\": \"New York\", \"street\": \"5th Avenue\", \"streetNumber\": 101}}, {\"firstname\": \"Bob\", \"lastname\": \"Johnson\", \"age\": 17, \"address\": {\"city\": \"Los Angeles\", \"street\": \"Sunset Boulevard\", \"streetNumber\": 202}}]}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}