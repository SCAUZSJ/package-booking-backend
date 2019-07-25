package com.oocl.packagebooking.service;


import com.oocl.packagebooking.entity.Parcel;
import com.oocl.packagebooking.repository.ParcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParcelService {

    private final String LOCATION = "";
    @Autowired
    private ParcelRepository parcelRepository;


    public Parcel add(Parcel parce) {
        parce.setStatus("未预约");
        return parcelRepository.saveAndFlush(parce);
    }
}
