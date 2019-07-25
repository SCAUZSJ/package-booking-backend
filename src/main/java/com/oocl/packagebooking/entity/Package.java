package com.oocl.packagebooking.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="package")
public class Package {

    @Id
    private String id;

    @Column(name="owner")
    private String owner;

    @Column(name="phone")
    private String phone;

    @Column(name="weight")
    private double weight;

    @Column(name="status")
    private String status;

    @Column(name="ap_time")
    private Timestamp apTime;

    public Package() {
    }

    public Package(String id, String owner, String phone, double weight) {
        this.id = id;
        this.owner = owner;
        this.phone = phone;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getApTime() {
        return apTime.getTime();
    }

    public void setApTime(Timestamp apTime) {
        this.apTime = apTime;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
