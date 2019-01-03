package com.yishan.javaplus.repository;

import com.yishan.javaplus.domain.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> findAll();
    Car findByVin(String vin);

//    @Query("Select c FROM cars c LEFT JOIN FETCH cars.images")
//    List<CharArrayReader> findAllWithImage();
//    @Query("Select c FROM cars c LEFT JOIN FETCH c.images where c.id = ?1")
//    List<Car> findByIdWithImage(Long Id);



}
