package com.yishan.javaplus.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    private Long id;

    @Column(name = "vin")
    private String vin;

    @Column(name = "model")
    public String model;

    @Column(name = "type")
    public String type;


    public Car(){

    }

    public String getVin(){
        return this.vin;
    }
    public void setVin(String vin){
        this.vin = vin;
    }

    public String getModel(){
        return this.model;
    }
    public void setModel(String model){
        this.model = model;
    }

    public String getType(){
        return this.type;
    }
    public void setType(String type){
        this.type = type;
    }
}
