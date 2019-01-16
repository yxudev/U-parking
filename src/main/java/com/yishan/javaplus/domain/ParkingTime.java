package com.yishan.javaplus.domain;


import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "time_duration")
public class ParkingTime {
    @Id
//    @GeneratedValue(strategy=SEQUENCE, generator="parking_time_id_seq")
//    @SequenceGenerator(name="parking_time_id_seq", sequenceName="parking_time_id_seq", allocationSize=1)
    @GeneratedValue(strategy=SEQUENCE, generator="time_duration_id_seq")
    @SequenceGenerator(name="time_duration_id_seq", sequenceName="time_duration_id_seq", allocationSize=1)
    private Long id;

    @Column(name = "parking_min")
    public String min;

    @Column(name = "parking_days")
    private String days;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private Car car;
//
//    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinColumn(name = "plate_id")
//    private Plate plate;

    public ParkingTime(Long id){
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getMin(){
        return this.min;
    }
    public void setMin(String min){
        this.min = min;
    }

    public String  getDays(){
        return this.days;
    }
    public void setDays(String days){
        this.days = days;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
