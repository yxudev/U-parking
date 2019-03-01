package com.yishan.javaplus.domain;


import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "cars_id_seq")
    @SequenceGenerator(name = "cars_id_seq", sequenceName = "cars_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "vin", unique = true)
    private String vin;

    @Column(name = "model")
    public String model;

    @Column(name = "body_type")
    public String bodyType;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car", cascade = CascadeType.ALL)
    private List<ParkingTime> parkingTimes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car", cascade = CascadeType.ALL)
    private CarImages carImages;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "car", cascade = CascadeType.ALL)
    private Plate plate;

    public List<ParkingTime> getParkingTimes() {
        return parkingTimes;
    }

    public Long getId() {
        return id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

}
