package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.entity.Parcel;
import com.oocl.packagebooking.respone.ResponseDIY;
import com.oocl.packagebooking.service.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/parcels")
public class ParcelController {
    @Autowired
    private ParcelService parcelService;

    @PostMapping(produces = {"application/json"})
    public ResponseDIY add(@RequestBody Parcel parce) throws RuntimeException{

        return new ResponseDIY(HttpStatus.CREATED.value(),parcelService.add(parce));
    }
    @GetMapping()
    public ResponseDIY findByStatus(@RequestParam("status") String status){
        return new ResponseDIY(HttpStatus.OK.value(),parcelService.findByStatus(status));
    }

    @PutMapping("/{id}")
    public ResponseDIY updateById(@PathVariable String id, @RequestBody Parcel parcel){
        return new ResponseDIY(HttpStatus.OK.value(),parcelService.update(id,parcel));
    }
    @PatchMapping("/{id}")
    public ResponseDIY updateApTime(@PathVariable String id, @RequestParam("apTime") long apTime){
        return new ResponseDIY(HttpStatus.OK.value(),parcelService.updateApTime(id,apTime));
    }



}
