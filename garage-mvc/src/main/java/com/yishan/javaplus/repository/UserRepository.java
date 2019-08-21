package com.yishan.javaplus.repository;

import com.yishan.javaplus.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();
    List<User> findByLastName (String lastName);
    List<User> findByFirstName (String firstName);
    User findByEmail (String email);
    User findByUsername (String username);


//    @Query
//            ("Select u FROM users LEFT JOIN FETCH users.images")
//    List<String> findAllWithImage();
//    @Query
//            ("Select u FROM users u LEFT JOIN FETCH u.images where u.id = ?1")
//    List<String> findByIdWithImage(Long Id);

    @Query("select u from User u where u.id=?1")
    User findByIdWithLol(Long Id);

    //select u from User u where u.username

    @Query("select u from User u order by u.username")
    List<User> findAllOrderByUsername(String username);
}
