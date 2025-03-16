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
class TeacherControllerIntegrationTest {
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
    void getAllTeachers() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/address")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + token))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    void shouldReturnSpecificTeacher() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/teachers/{id}", 3)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + token))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstname").value("Jindřich"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastname").value("Zděnek"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(59));
    }

    @Test
    void createTeacher() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/teachers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + token)
                        .content("{\"firstname\": \"Jan\", \"lastname\": \"Novák\", \"age\": 50, \"salary\": 55000}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}