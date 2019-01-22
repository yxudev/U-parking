package com.yishan.javaplus.service;

import com.yishan.javaplus.config.AppConfig;
import com.yishan.javaplus.domain.User;
import com.yishan.javaplus.repository.UserRepository;
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

//    @Test
//    @Transactional
//    public void findByIdTest() {
//        User u = new User();
//        u.setUsername("Admin");
//        u.setEmail("gmail@gmail.com");
//        u.setFirstName("sa");
//        u.setLastName("bi");
//        userRepository.save(u);
//        Optional<User> testUser = userRepository.findById(u.getId());
//        assertNotNull(testUser);
//        assertEquals(u.getId(), testUser.get().getId());
//    }

    @Test
    @Transactional
    public void createNewUserTest() {
        User u = new User();
        u.setUsername("Admin");
        u.setEmail("gmail@gmail.com");
        u.setFirstName("sa");
        u.setLastName("bi");
        userRepository.save(u);
        Optional<User> testUser = userRepository.findById(u.getId());
        assertNotNull(testUser);
        assertEquals(u.getId(), testUser.get().getId());
    }
}