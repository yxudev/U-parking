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

//    public Car(String vin, String model, String bodyType, List<ParkingTime> parkingTimes, Plate plate) {
//        this.vin = vin;
//        this.model = model;
//        this.bodyType = bodyType;
//        this.parkingTimes = parkingTimes;
//        this.plate = plate;
//    }

    @Column(name = "model")
    public String model;

    @Column(name = "body_type")
    public String bodyType;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car", cascade = CascadeType.ALL)
    private List<ParkingTime> parkingTimes;

    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "car", cascade = CascadeType.ALL)
    //private CarImages carImages;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "car", cascade = CascadeType.ALL)
    private Plate plate;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "car", cascade = CascadeType.ALL)
    private Garage garage;

    public Car() {

    }

    public List<ParkingTime> getParkingTimes() {
        return parkingTimes;
    }

    public Garage getGarage(){
        return garage;
    }

    public Plate getPlate() {
        return plate;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setParkingTimes(List<ParkingTime> parkingTimes) {
        this.parkingTimes = parkingTimes;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    public void setPlate(Plate plate) {
        this.plate = plate;
    }
}
