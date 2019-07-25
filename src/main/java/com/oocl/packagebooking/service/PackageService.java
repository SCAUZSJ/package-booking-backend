package com.oocl.packagebooking.service;


import com.oocl.packagebooking.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class PackageService {

    private final String LOCATION = "";
    @Autowired
    private PackageRepository PackageRepository;


}
