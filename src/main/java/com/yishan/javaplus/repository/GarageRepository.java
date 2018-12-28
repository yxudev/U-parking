//package com.yishan.javaplus.repository;
//
//import com.yishan.javaplus.domain.User;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//
//import java.util.List;
//
//public interface GarageRepository extends CrudRepository<User, Long> {
//
//    List<User> findAll();
//    @Query
//            ("Select g FROM garages LEFT JOIN FETCH garages.images")
//    List<String> findAllWithImage();
//    @Query
//            ("Select g FROM garages g LEFT JOIN FETCH g.images where g.id = ?1")
//    List<String> findByIdWithImage(Long Id);
//}
