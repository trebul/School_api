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
class ScheduleControllerIntegrationTest {
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
    void getAllSchedules() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/schedule")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + token))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    void shouldReturnSpecificSchedule() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/schedule/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + token))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.schoolYear").value("2024/2025"));
    }

    @Test
    void createSchedule() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/schedule")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + token)
                .content("{\"id\": 2, \"schoolYear\": \"2024/2025\", \"classroom\": {\"id\": 8, \"name\": \"c4d\", \"year\": 2024, \"floor\": 3, \"teacher\": {\"teacherid\": 9, \"firstname\": \"Jindra\", \"lastname\": \"Mandík\", \"age\": 50, \"salary\": 55000}, \"student\": [{\"id\": 15, \"firstname\": \"Alice\", \"lastname\": \"Smith\", \"age\": 16, \"address\": {\"id\": 14, \"city\": \"New York\", \"street\": \"5th Avenue\", \"streetNumber\": 101}}, {\"id\": 16, \"firstname\": \"Bob\", \"lastname\": \"Johnson\", \"age\": 17, \"address\": {\"id\": 15, \"city\": \"Los Angeles\", \"street\": \"Sunset Boulevard\", \"streetNumber\": 202}}]}, \"subject\": [{\"id\": 3, \"subjectName\": \"Čeština\", \"startOfSubject\": \"2024-10-13T08:00:00.000+00:00\", \"endOfSubject\": \"2024-10-13T09:00:00.000+00:00\"}, {\"id\": 4, \"subjectName\": \"Zeměpis\", \"startOfSubject\": \"2024-10-13T10:00:00.000+00:00\", \"endOfSubject\": \"2024-10-13T11:00:00.000+00:00\"}]}")
        )                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}