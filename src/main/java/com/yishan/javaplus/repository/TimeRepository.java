//package com.yishan.javaplus.repository;
//
//import com.yishan.javaplus.domain.User;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//
//import java.util.List;
//
//public interface TimeRepository extends CrudRepository<User, Long> {
//
//    List<User> findAll();
//    @Query
//            ("Select t FROM time_duration LEFT JOIN FETCH time_duration.images")
//    List<String> findAllWithImage();
//    @Query
//            ("Select t FROM time_duration  t LEFT JOIN FETCH t.images where t.id = ?1")
//    List<String> findByIdWithImage(Long Id);
//}
