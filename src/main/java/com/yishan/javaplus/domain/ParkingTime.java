package com.yishan.javaplus.domain;


import javax.persistence.*;

@Entity
@Table(name = "time_duration")
public class ParkingTime {
    @Id
    private Long id;

    @Column(name = "parking_min")
    public int min;

    @Column(name = "parking_days")
    private String days;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "cars_id_seq")
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "plates_id_seq")
    private Plate plate;

    public ParkingTime(Long id){

        this.id = id;
    }

    public Integer getMin(){
        return this.min;
    }
    public void setMin(Integer min){
        this.min = min;
    }

    public String  getDays(){
        return this.days;
    }
    public void setDays(String days){
        this.days = days;
    }
}
