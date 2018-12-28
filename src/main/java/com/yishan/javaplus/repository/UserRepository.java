//package com.yishan.javaplus.repository;
//
//import com.yishan.javaplus.domain.User;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//
//import java.util.List;
//
//public interface UserRepository extends CrudRepository<User, Long> {
//
//    List<User> findAll();
//    @Query
//            ("Select u FROM users LEFT JOIN FETCH users.images")
//    List<String> findAllWithImage();
//    @Query
//            ("Select u FROM users u LEFT JOIN FETCH u.images where u.id = ?1")
//    List<String> findByIdWithImage(Long Id);
//}
