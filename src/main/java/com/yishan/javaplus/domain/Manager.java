package com.yishan.javaplus.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car_manager")
public class Manager {
    @Id
    private Long id;

    @Column(name = "add_tips")
    private float tip;



    public Manager(){

    }
}
