package com.example.api.controller;

import com.example.api.dbunit.CustomDeleteOperation;
import com.example.api.dbunit.DataSourceDBUnitTest;
import com.example.api.model.Address;
import com.example.api.repository.AddressRepository;
import com.jayway.jsonpath.JsonPath;
import jakarta.transaction.Transactional;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.sql.DataSource;
import java.io.InputStream;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AddressControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    private AuthHelper authHelper;

    @Autowired
    private DataSource dataSource;
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    DataSourceDBUnitTest dataSourceDBUnitTest;

    private String token;
    private IDatabaseTester databaseTester;
    @BeforeEach
    @Transactional
    void setUp() throws Exception {
        authHelper = new AuthHelper(mockMvc);

        databaseTester = new JdbcDatabaseTester("org.h2.Driver",
                DataSourceDBUnitTest.getConnectionUrl(),
                "sa", "");
        databaseTester.setSetUpOperation(new CustomDeleteOperation());

        IDataSet dataSet = DataSourceDBUnitTest.getDataSet("data.xml");
        databaseTester.setDataSet(dataSet);

        databaseTester.onSetup();

        token = authHelper.obtainAccessToken("lmaocháč", "cze");
    }
    @AfterEach
    void tearDown() throws Exception {
        // Clean up data after each test
        databaseTester.setTearDownOperation(DatabaseOperation.DELETE_ALL);
        databaseTester.onTearDown();
    }
    @Test
    void getAllAddresses() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/address")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + token))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void createAddress() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/address")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + token)
                        .content("{\"id\": 999,\"city\": \"Brno\", \"street\": \"Zelená\", \"streetNumber\": 100}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    void editAddress() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/address/{id}", 999)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + token)
                        .content("{\"city\": \"Plzeň\", \"street\": \"Zelená\", \"streetNumber\": 75}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    void shouldReturnSpecificAddress() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/address/{id}", 551)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + token))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.city").value("Plzeň"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.street").value("Stará"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.streetNumber").value(37));
    }
    @Test
    void deleteAddress() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/address/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + token))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
