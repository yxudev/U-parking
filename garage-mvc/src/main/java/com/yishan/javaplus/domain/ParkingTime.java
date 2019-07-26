package com.yishan.javaplus.domain;


import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "time_duration")
public class ParkingTime {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "time_duration_id_seq")
    @SequenceGenerator(name = "time_duration_id_seq", sequenceName = "time_duration_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "parking_min")
    public int min;

    @Column(name = "parking_days")
    private int days;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private Car car;

    public ParkingTime(){

    }

    public ParkingTime(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getMin() {
        return this.min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getDays() {
        return this.days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
