package com.yishan.javaplus.service;

import com.yishan.javaplus.domain.Authority;
import com.yishan.javaplus.domain.User;
import com.yishan.javaplus.repository.AuthorityRepository;
import com.yishan.javaplus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private UserRepository userRepository;


    public AuthorityService(){

    }


    public User addAuthority(User user, String role) {
        Authority authority = new Authority();
        authority.setAuthority(role);
        authority.setUser(user);
        authorityRepository.save(authority);
        return userRepository.save(user);
    }

    public List<Authority> findAuthorityByUser(User user) {
        return this.authorityRepository.findByUser(user.getId());
    }
}
