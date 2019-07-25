package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.entity.Parcel;
import com.oocl.packagebooking.respone.ResponseDIY;
import com.oocl.packagebooking.service.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parcels")
public class ParcelController {
    @Autowired
    private ParcelService ParcelService;

    @PostMapping(produces = {"application/json"})
    public ResponseDIY add(@RequestBody Parcel parce) throws RuntimeException{

        return new ResponseDIY(HttpStatus.CREATED.value(),ParcelService.add(parce));
    }
    @GetMapping()
    public ResponseDIY findAll(){
        return new ResponseDIY(HttpStatus.OK.value(),ParcelService.findAll());
    }



}
