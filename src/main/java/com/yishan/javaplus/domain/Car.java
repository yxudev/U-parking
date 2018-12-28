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

    @Column(name = "body_type")
    public String bodyType;

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
