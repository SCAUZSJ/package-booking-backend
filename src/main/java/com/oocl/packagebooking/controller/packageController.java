package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.respone.ResponseDIY;
import com.oocl.packagebooking.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/packages")
public class packageController {
    @Autowired
    private PackageService PackageService;



}
