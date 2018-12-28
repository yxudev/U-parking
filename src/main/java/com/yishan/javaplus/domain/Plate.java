package com.yishan.javaplus.domain;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "plates")
public class Plate {
    @Id
    private Long id;

    @Column(name = "license_number")
    private String licenseNumber;

    @Column(name = "state")
    public String state;


    @OneToOne(fetch = FetchType.LAZY,mappedBy = "cars",cascade = CascadeType.ALL)
    private Car car;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "time_duration",cascade = CascadeType.ALL)
    private List<ParkingTime> parkingTimes;


    public Plate() {

    }

    public String getLicenseNumber() {
        return this.licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getState(){
        return this.state;
    }
    public void setState(String state){
        this.state = state;
    }
}

