package com.yishan.javaplus.domain;


import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity
@Table(name = "garages")
public class Garage {
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="garages_id_seq")
    @SequenceGenerator(name="garages_id_seq", sequenceName="garages_id_seq", allocationSize=1)
    private Long id;

    @Column(name = "lot_number")
    private int lotNumber;

    @Column(name = "city")
    public String city;

    @Column(name = "garage_name")
    public String  garageName;


    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "cars_id")
    private Car car;


    public Garage(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(int lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGarageName() {
        return garageName;
    }

    public void setGarageName(String garageName) {
        this.garageName = garageName;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
