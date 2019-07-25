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

import java.sql.Timestamp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

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
        //given
        Parcel parcel = new Parcel("20193232","milo","1364251414",5.0);
        String objectJson = new org.json.JSONObject(parcel).toString();
        //when
        String response = this.mockMvc.perform(post("/parcels").contentType(MediaType.APPLICATION_JSON_UTF8).
                content(objectJson)).andReturn().getResponse().getContentAsString();
        JSONObject obj = new JSONObject(response);
        //then
        Assertions.assertEquals(201,obj.getInt("code"));
    }
    @Test
    public void should_return_parcels_when_get() throws Exception {
        //given
        Parcel parcel = new Parcel("20193232","milo","1364251414",5.0);
        parcel.setStatus("未预约");
        repository.saveAndFlush(parcel);
        //when
        String response = this.mockMvc.perform(get("/parcels?status=未预约")).andReturn().getResponse().getContentAsString();
        JSONObject json = new JSONObject(response);
        //then
        Assertions.assertEquals("20193232",json.getJSONArray("data").getJSONObject(0).get("id"));
    }
    @Test
    public void should_return_new_object_info_when_alter_status() throws Exception {
        //given
        Parcel parcel = new Parcel("20193232","milo","1364251414",5.0);
        parcel.setStatus("已预约");
        parcel.setApTime(new Timestamp(System.currentTimeMillis()));
        repository.saveAndFlush(parcel);
        //when
        parcel.setStatus("已取件");
        String objectJson = new org.json.JSONObject(parcel).toString();
        String response = this.mockMvc.perform(put("/parcels/20193232").contentType(MediaType.APPLICATION_JSON_UTF8).
                content(objectJson)).andReturn().getResponse().getContentAsString();
        JSONObject obj = new JSONObject(response);
        Assertions.assertEquals("已取件",obj.getJSONObject("data").getString("status"));
    }
    @Test
    public void should_return_result_when_alter_apTime() throws Exception {
        //given
        Parcel parcel = new Parcel("20193232","milo","1364251414",5.0);
        parcel.setStatus("未预约");
        repository.saveAndFlush(parcel);
        //when
        String objectJson = new org.json.JSONObject(parcel).toString();
        String response = this.mockMvc.perform(patch("/parcels/20193232?apTime=1564022727").contentType(MediaType.APPLICATION_JSON_UTF8).
                content(objectJson)).andReturn().getResponse().getContentAsString();
        JSONObject obj = new JSONObject(response);
        Assertions.assertEquals(true,obj.getBoolean("data"));
    }

}
