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
    private String lotNumber;

    @Column(name = "city")
    public String city;

    @Column(name = "garage_name")
    public String  garageName;


    public Garage(){

    }
    public Long getId() { return id; }
    public String getLotNumber(){
        return this.lotNumber;
    }
    public void setLotNumber(String lotNumber){
        this.lotNumber = lotNumber;
    }

    public String getCity(){
        return this.city;
    }
    public void setCity(String city){
        this.city = city;
    }

    public String getGarageName(){
        return this.garageName;
    }
    public void setGarageName(String garageName){
        this.garageName = garageName;
    }
}
