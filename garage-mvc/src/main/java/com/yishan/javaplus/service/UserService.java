package com.yishan.javaplus.service;

import com.amazonaws.services.dynamodbv2.xspec.L;
import com.amazonaws.services.dynamodbv2.xspec.S;
import com.yishan.javaplus.domain.User;
import com.yishan.javaplus.enumdef.AuthorityRole;
import com.yishan.javaplus.repository.UserRepository;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityService authorityService;

    private ArrayList<String> ArrayList;

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long Id) {
        return userRepository.findById(Id).get();
    }

    public List<User> findByLastName(String lastName) {
        List<User> user = userRepository.findByLastName(lastName);
        return user;
    }

    public List<User> findByFirstName(String FirstName) {
        List<User> user = userRepository.findByFirstName(FirstName);
        return user;
    }

    public User findByUsername(String username) {
        User result = userRepository.findByUsername(username);
        return result;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();



    @Transactional
    public User createNewUser(User newUser) {
//        String code = UUID.randomUUID().toString();
        String encodePassword = encoder.encode(newUser.getPassword());
        newUser.setPassword(encodePassword);
        save(newUser);
        authorityService.addAuthority(newUser, AuthorityRole.ROLE_REGISTERED_USER);
        save(newUser);
        return save(newUser);
    }

    @Transactional
    public User changeUserName(User user, String username) {
        user.setUsername(username);
        return userRepository.save(user);

    }

    @Transactional
    public User changeUserEverything(User user) {
        String encodePassword = encoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        return userRepository.save(user);

    }

    @Transactional
    public List<User> findAllOrderByUsername(String username){
        List<User> usernames = userRepository.findAllOrderByUsername(username);
        return usernames;
    }


    public List<User> sortAllUsersByUsernames(List<User> usr) {
       Collections.sort(usr);
        return usr;
    }


    @Transactional
    public User findByIdWithLol(Long Id) {
        return userRepository.findByIdWithLol(Id);
    }

}
