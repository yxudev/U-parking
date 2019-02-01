package com.yishan.javaplus.service;

import com.yishan.javaplus.domain.Authority;
import com.yishan.javaplus.domain.User;
import com.yishan.javaplus.enumdef.AuthorityRole;
import com.yishan.javaplus.repository.AuthorityRepository;
import com.yishan.javaplus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
    public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

//    @Override
//    protected CrudRepository<User, Long> getCrudRepository(){return userRepository;}

//    @Transactional
//    public User createUser(User newUser){
//
//    }



    public User save(User user){return userRepository.save(user);}

    public List<User> findAll() {
//        List<User> users = Lists.newArrayList(userRepository.findAll());
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

    public User addAuthority(User user, String role){
        Authority authority = new Authority();
        authority.setAuthority(role);
        authority.setUser(user);
        authorityRepository.save(authority);
        return userRepository.save(user);
        }

    @Transactional
    public User createNewUser(User newUser) {
        String code = UUID.randomUUID().toString();
        String encodePassword = encoder.encode(newUser.getPassword());
        newUser.setPassword(encodePassword);
        save(newUser);
        addAuthority(newUser, AuthorityRole.ROLE_REGISTERED_USER);
        save(newUser);
        return newUser;
    }

}
