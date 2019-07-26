package com.yishan.javaplus.repository;

import com.yishan.javaplus.domain.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> findAll();
    Car findByVin(String vin);
    Car findByModel(String model);
    Car findByBodyType(String bodyType);



    @Query("Select car FROM Car car LEFT JOIN FETCH car.plate")
    List<Car> findAllWithPlate(Car car);



    @Query("Select c FROM Car c LEFT JOIN FETCH c.plate where c.id = ?1")
    Car findByIdWithPlate(Long carId);

    @Query("Select c FROM Car c LEFT JOIN FETCH c.parkingTimes where c.id = ?1")
    Car findByIdWithParkingTime(Long carId);


}

