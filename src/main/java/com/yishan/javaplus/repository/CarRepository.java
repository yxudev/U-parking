package com.yishan.javaplus.repository;

import com.yishan.javaplus.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<User, Long> {

    List<User> findAll();
    @Query("Select c FROM cars LEFT JOIN FETCH cars.images")
    List<String> findAllWithImage();
    @Query("Select c FROM cars c LEFT JOIN FETCH c.images where c.id = ?1")
    List<String> findByIdWithImage(Long Id);



}
