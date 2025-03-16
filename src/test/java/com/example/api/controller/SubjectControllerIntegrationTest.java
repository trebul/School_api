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
class SubjectControllerIntegrationTest {
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
    void getAllSubjects() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/subject")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + token))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    void shouldReturnSpecificSubject() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/subject/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + token))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.subjectName").value("Čeština"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startOfSubject").value("2024-10-13T08:00:00.000+00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endOfSubject").value("2024-10-13T09:00:00.000+00:00"));
    }

    @Test
    void createSubject() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/subject")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + token)
                        .content("{\"subjectName\": \"Dějepis\", \"startOfSubject\": \"2024-10-13T08:00:00.000+00:00\", \"endOfSubject\": \"2024-10-13T09:00:00.000+00:00\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}