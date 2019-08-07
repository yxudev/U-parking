package com.yishan.javaplus.extend.security;


import com.yishan.javaplus.config.AppConfig;
import com.yishan.javaplus.domain.User;
import com.yishan.javaplus.repository.AuthorityRepository;
import com.yishan.javaplus.repository.UserRepository;
import com.yishan.javaplus.service.UserService;
import org.checkerframework.checker.units.qual.A;
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
import static org.junit.Assert.assertNotNull;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class UserDetailsServiceImplTest extends UserDetailsServiceImpl{

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;


    @Test
    @Transactional
    public void loadUserByUsernameTest(){
            User user = new User();
            user.setUsername("usr");
            user.setLastName("last");
            user.setFirstName("first");
            user.setPassword("halashdsafals");
            user.setEmail("j.logan@gmail.com ");
            user.setPhoneNumber("123-456-7899");
            user.setZipCode("20001");
            userService.save(user);

            UserDetails userTest = userDetailsService.loadUserByUsername("usr");
            assertNotNull(userTest);
            assertEquals(user.getUsername(), userTest.getUsername());
        }

}
