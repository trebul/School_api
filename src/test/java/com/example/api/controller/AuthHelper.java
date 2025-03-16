package com.example.api.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;

public class AuthHelper {

    private MockMvc mockMvc;

    public AuthHelper(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    public String obtainAccessToken(String username, String password) throws Exception {
        String loginPayload = "{ \"username\": \"" + username + "\", \"password\": \"" + password + "\" }";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/authenticate") // Replace with your login endpoint
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(loginPayload))
                .andReturn();

        String response = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response);
        return jsonNode.get("token").asText();
    }
}