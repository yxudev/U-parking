//package com.yishan.javaplus.repository;
//
//import com.yishan.javaplus.domain.User;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//
//import java.util.List;
//
//public interface PlateRepository extends CrudRepository<User, Long> {
//
//    List<User> findAll();
//    @Query
//            ("Select p FROM plates LEFT JOIN FETCH plates.images")
//    List<String> findAllWithImage();
//    @Query
//            ("Select p FROM plates p LEFT JOIN FETCH p.images where p.id = ?1")
//    List<String> findByIdWithImage(Long Id);
//}
