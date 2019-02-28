package com.yishan.javaplus.domain;


import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "car_images")
public class CarImages {

    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="cars_id_seq")
    @SequenceGenerator(name="cars_id_seq", sequenceName="cars_id_seq", allocationSize=1)
    private Long id;

    @Column(name = "vin")
    private String vin;

    @Column(name = "url", unique = true)
    private String url;

    @Column(name = "car_images")
    private String CarImages;

    public CarImages(){

    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Car car;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarImages() {
        return CarImages;
    }

    public void setCarImages(String carImages) {
        CarImages = carImages;
    }
}
