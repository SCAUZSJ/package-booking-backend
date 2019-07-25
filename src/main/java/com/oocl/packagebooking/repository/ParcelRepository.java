package com.oocl.packagebooking.repository;

import com.oocl.packagebooking.entity.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParcelRepository extends JpaRepository<Parcel, String> {

    List<Parcel> findByStatus(String status);

}
