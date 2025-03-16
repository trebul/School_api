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
class GradesControllerIntegrationTest {
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
    void getAllGrades() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/grades")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + token))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    void shouldReturnSpecificGrade() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/grades/{id}", 4)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + token))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.grade").value(90))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dateOfGrade").value("2024-10-13"));
    }

    @Test
    void createGrade() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/grades")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + token)
                        .content("{\"grade\": 85, \"dateOfGrade\": \"2024-11-15\", \"teacher\": {\"teacherid\": 10,\"firstname\": \"Eva\", \"lastname\": \"Kovářová\", \"age\": 42, \"salary\": 60000}, \"student\": {\"firstname\": \"John\", \"lastname\": \"Doe\", \"age\": 17, \"address\": {\"city\": \"Los Angeles\", \"street\": \"Main Street\", \"streetNumber\": 202}}}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}