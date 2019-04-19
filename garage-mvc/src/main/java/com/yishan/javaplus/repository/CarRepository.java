package com.yishan.javaplus.repository;

import com.yishan.javaplus.domain.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> findAll();
    Car findByVin(String vin);
    Car findByModel(String model);
    Car findByBodyType(String bodyType);
//    Car deleteByCarId(Long aLong);
//    Car addCar(String carName);

//    @Query("Select c FROM Car c LEFT JOIN FETCH c.images")
//    List<Car> findAllWithImage();
//    @Query("Select c FROM cars c LEFT JOIN FETCH c.images where c.id = ?1")
//    List<Car> findByIdWithImage(Long Id);



}
