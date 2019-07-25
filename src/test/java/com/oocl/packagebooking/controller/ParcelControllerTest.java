package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.entity.Parcel;
import com.oocl.packagebooking.repository.ParcelRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParcelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ParcelRepository repository;

    @Test
    public void should_return_code_201_when_post() throws Exception {
        Parcel parcel = new Parcel("20193232","milo","1364251414",5.0);
        String objectJson = new org.json.JSONObject(parcel).toString();
        String response = this.mockMvc.perform(post("/parcels").contentType(MediaType.APPLICATION_JSON_UTF8).
                content(objectJson)).andReturn().getResponse().getContentAsString();
        JSONObject obj = new JSONObject(response);
        Assertions.assertEquals(201,obj.getInt("code"));
    }
    @Test
    public void should_return_employees_when_get() throws Exception {
        Parcel parcel = new Parcel("20193232","milo","1364251414",5.0);
        parcel.setStatus("未预约");
        repository.saveAndFlush(parcel);
        String response = this.mockMvc.perform(get("/parcels")).andReturn().getResponse().getContentAsString();
        JSONObject json = new JSONObject(response);
        Assertions.assertEquals("20193232",json.getJSONArray("data").getJSONObject(0).get("id"));
    }

}
