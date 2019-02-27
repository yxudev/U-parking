package com.yishan.javaplus.service;

import com.yishan.javaplus.domain.Authority;
import com.yishan.javaplus.domain.User;
import com.yishan.javaplus.repository.AuthorityRepository;
import com.yishan.javaplus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private User user;

    public AuthorityService(){

    }

    public List<Authority> findAll() {
        return authorityRepository.findAll();
    }


//
//    public Authority findByUser(){
//        return authorityRepository.findByUser(username);
//    }



}
