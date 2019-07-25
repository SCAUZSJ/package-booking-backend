package com.oocl.packagebooking.service;


import com.oocl.packagebooking.entity.Parcel;
import com.oocl.packagebooking.repository.ParcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class ParcelService {

    private final String LOCATION = "";
    @Autowired
    private ParcelRepository parcelRepository;


    public Parcel add(Parcel parce) {
        parce.setStatus("未预约");
        return parcelRepository.saveAndFlush(parce);
    }

    public List<Parcel> findAll() {
        return parcelRepository.findAll();
    }

    public Parcel update(String id, Parcel parcel) {
        parcel.setId(id);
        return parcelRepository.saveAndFlush(parcel);
    }
    public boolean updateApTime(String id , String apTime){
        Parcel parcel = parcelRepository.findById(id).get();
        parcel.setStatus("已预约");
        parcel.setApTime(new Timestamp(Integer.parseInt(apTime)));
        try {
            parcelRepository.saveAndFlush(parcel);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Parcel> findByStatus(String status) {
        return parcelRepository.findByStatus(status);
    }
}
