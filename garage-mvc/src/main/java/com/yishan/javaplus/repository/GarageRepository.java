package com.yishan.javaplus.repository;

import com.yishan.javaplus.domain.Car;
import com.yishan.javaplus.domain.Garage;
import com.yishan.javaplus.domain.Plate;
import com.yishan.javaplus.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GarageRepository extends CrudRepository<Garage, Long> {

//    @Query
//            ("Select g FROM garages LEFT JOIN FETCH garages.images")
//    List<String> findAllWithImage();


    @Query("Select g FROM Garage g LEFT JOIN FETCH g.car where g.id = ?1")
    Garage findByIdWithCar(Long garageId);
}
