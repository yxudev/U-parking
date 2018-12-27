package com.yishan.javaplus.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "time_duration")
public class Time {
    @Id
    private Long id;

    @Column(name = "parking_min")
    public int min;

    @Column(name = "parking_days")
    private String days;



    public Time(){

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
