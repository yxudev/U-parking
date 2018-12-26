package com.yishan.javaplus.repository;

import com.yishan.javaplus.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ManagerRepository extends CrudRepository<User, Long> {

    List<User> findAll();
    @Query
            ("Select m FROM managers LEFT JOIN FETCH managers.images")
    List<String> findAllWithImage();
    @Query
            ("Select m FROM managers m LEFT JOIN FETCH m.images where m.id = ?1")
    List<String> findByIdWithImage(Long Id);
}
