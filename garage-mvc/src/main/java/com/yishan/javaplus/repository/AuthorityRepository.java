package com.yishan.javaplus.repository;

import com.yishan.javaplus.domain.Authority;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorityRepository extends CrudRepository<Authority, Long> {

    @Query("select a from Authority a where a.user.id=?1")
    List<Authority> findByUser(Long userId);
}
