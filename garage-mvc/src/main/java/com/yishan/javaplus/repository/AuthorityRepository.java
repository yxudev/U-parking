package com.yishan.javaplus.repository;

import com.yishan.javaplus.domain.Authority;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorityRepository extends CrudRepository<Authority, Long> {

    List<Authority> findAll();

    Authority findByUser(String username);




}
