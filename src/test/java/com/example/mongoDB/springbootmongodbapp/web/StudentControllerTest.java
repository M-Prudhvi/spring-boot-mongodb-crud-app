package com.example.mongoDB.springbootmongodbapp.web;

import com.example.mongoDB.springbootmongodbapp.SpringbootMongodbAppApplicationTests;
import com.example.mongoDB.springbootmongodbapp.web.model.RetrieveStudentResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.Assert.*;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
//@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class StudentControllerTest extends SpringbootMongodbAppApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAllStudents() throws Exception{
        MvcResult mvcResult = this.mockMvc.perform(get("/app/mongo-app/retrieve-all-students")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String responseString = mvcResult.getResponse().getContentAsString();

        RetrieveStudentResponse retrieveStudentResponse = objectMapper.readValue(responseString, RetrieveStudentResponse.class);
        assertNotNull(retrieveStudentResponse);
        assertNotNull(retrieveStudentResponse.getStudentList());
        assertEquals(4, retrieveStudentResponse.getStudentList().size());
    }
}
