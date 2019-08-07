package com.yishan.javaplus.service;


import com.yishan.javaplus.config.AppConfig;
import com.yishan.javaplus.domain.User;
import com.yishan.javaplus.repository.UserRepository;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class UserServiceTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    User user = new User();


    @Test
    @Transactional
    public void findByIdTest() {

        user.setFirstName("anon");
        user.setLastName("lolllll");
        userRepository.save(user);
        Optional<User> testUser = userRepository.findById(user.getId());
        assertNotNull(testUser);
        assertEquals(user.getId(), testUser.get().getId());
    }

    @Test
    @Transactional
    public void createNewUserTest() {
        user.setFirstName("wvm");
        user.setLastName("lkdnfn");
        user.setEmail("fshkn@fsdkn.com");
        user.setUsername("usr");
        user.setPassword("www");
        userService.save(user);
        User testUser = userService.findById(user.getId());
        assertNotNull(testUser);
        assertEquals(user.getId(), testUser.getId());

    }


}
