package com.yishan.javaplus.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "managers")
public class Manager {
    @Id
    private Long id;

    @Column(name = "tips")
    private float tip;



    public Manager(){

    }

    public Long getId() { return id; }

    public float getTip() {
        return this.tip;
    }
    public void setTip(Integer tip){
        this.tip = tip;
    }
}
