package com.yishan.javaplus.repository;

import com.yishan.javaplus.domain.ParkingTime;
import com.yishan.javaplus.domain.Plate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParkingTimeRepository extends CrudRepository<ParkingTime, Long> {

    List<ParkingTime> findAll();

//    @Query
//    ("Select t FROM time_duration LEFT JOIN FETCH time_duration.images")
//    List<String> findAllWithImage();

    @Query
    ("Select t FROM ParkingTime t LEFT JOIN FETCH t.car where t.id = ?1")
    List<String> findByIdWithCar(Long ParkingId);
}
