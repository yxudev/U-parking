package com.yishan.javaplus.extend.security;


import com.yishan.javaplus.config.AppConfig;
import com.yishan.javaplus.domain.User;
import com.yishan.javaplus.repository.UserRepository;
import com.yishan.javaplus.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.TestCase.assertEquals;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class UserDetailsServiceImplTest extends UserDetailsServiceImpl{

    @Autowired
    public UserDetailsService userDetailsService;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    @Transactional
    public void loadUserByUsernameTest(){
            User uu = new User();
            uu.setUsername("lalal");
            uu.setLastName("saasas");
            uu.setFirstName("dasdsadadsasdadad");
            uu.setPassword("halashdsafals");
            uu.setEmail("j.logan@gmail.com ");
            uu.setPhoneNumber("123-456-7890");
            uu.setZipCode("22222");
            userRepository.save(uu);
            UserDetails lalal = userDetailsService.loadUserByUsername(uu.getUsername());
            assertEquals(uu.getUsername(), lalal.getUsername());
        }

}
