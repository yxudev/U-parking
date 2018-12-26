//package com.yishan.javaplus.repository;
//
//import com.yishan.javaplus.domain.User;
//import org.springframework.data.repository.CrudRepository;
//
//import java.util.List;
//
//public interface CarRepository extends CrudRepository<User, Long> {
//
//    List<User> findAll();
//
//    ("Select c FROM #{entityName} c LEFT JOIN FETCH c.images")
//    List<> findAllWithImage();
//
//    ("Select c FROM #{entityName} c LEFT JOIN FETCH c.images where c.id = ?1")
//    List<> findByIdWithImage(Long Id);
//
//
//
//}
