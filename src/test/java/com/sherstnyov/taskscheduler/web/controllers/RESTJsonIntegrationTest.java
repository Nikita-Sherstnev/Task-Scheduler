package com.sherstnyov.taskscheduler.web.controllers;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sherstnyov.taskscheduler.web.dto.TaskModel;
import com.sherstnyov.taskscheduler.web.dto.UserModel;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RESTJsonIntegrationTest {

    @Test
    public void defaultContentTypeIsJson() throws IOException {
        String jsonMimeType = "application/json";
        HttpUriRequest request = new HttpGet("http://localhost:8080/tasks");

        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();

        assertEquals(jsonMimeType, mimeType);
    }

    @Test
    public void retrieveAdminUsername() throws IOException {
        HttpUriRequest request = new HttpGet("http://localhost:8080/users/0");

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        String json = EntityUtils.toString(response.getEntity());
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        UserModel userModel = mapper.readValue(json, UserModel.class);

        assertEquals("admin", userModel.getUsername());
    }

    @Test
    public void retrieveTaskDescription() throws IOException {
        HttpUriRequest request = new HttpGet("http://localhost:8080/tasks/0");

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        String json = EntityUtils.toString(response.getEntity());
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        TaskModel userModel = mapper.readValue(json, TaskModel.class);

        assertEquals("Clean your room", userModel.getDescription());
    }
}
