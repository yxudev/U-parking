package com.yishan.javaplus.repository;

import com.yishan.javaplus.domain.Plate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlateRepository extends CrudRepository<Plate, Long> {

    List<Plate> findAll();

//    @Query("Select p FROM plates LEFT JOIN FETCH plates.images")
//    List<String> findAllWithImage();

    @Query("Select p FROM Plate p LEFT JOIN FETCH p.car where p.id = ?1")
    Plate findByIdWithCar(Long plateId);
}
