package com.yishan.javaplus.repository;

import com.yishan.javaplus.domain.Garage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GarageRepository extends CrudRepository<Garage, Long> {

//    @Query
//            ("Select g FROM garages LEFT JOIN FETCH garages.images")
//    List<String> findAllWithImage();


    List<Garage> findAll();
    Garage findByCity(String City);
    Garage findByLotNumber(int LotNumber);
    Garage findByGarageName(String GarageName);
    Garage deleteGarageById(Long Id);




    @Query("Select g FROM Garage g LEFT JOIN FETCH g.car where g.id = ?1")
    Garage findByLot(int lotNumber);



}
