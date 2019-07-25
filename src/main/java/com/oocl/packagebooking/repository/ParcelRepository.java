package com.oocl.packagebooking.repository;

import com.oocl.packagebooking.entity.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelRepository extends JpaRepository<Parcel, String> {

}
