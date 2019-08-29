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

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    User usr = new User();

    User ux = new User();

    User ui = new User();

    @Autowired
    private EntityManager em;



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



    @Test
    @Transactional
    public void sortAllUsersByUsernamesTest() {

        List<User> sorted = userService.sortAllUsersByUsernames(userService.findAll());
        List<User> original = new ArrayList<>(userService.findAll());
        Collections.sort(original);
        assertEquals (sorted, original);
    }


    @Test
    @Transactional
    public void getUsersListWithFirstAndLastNamesTest(){
        user.setFirstName("wvm");
        user.setLastName("lkdnfn");
        user.setEmail("fshkn@fsdkn.com");
        user.setUsername("ggg");
        user.setPassword("www");
        user.setZipCode("12345");
        user.setPhoneNumber("1");
        userService.save(user);

        usr.setFirstName("ekrjfnlak");
        usr.setLastName("lmjf");
        usr.setEmail("fshkn@fsdkn4.com");
        usr.setUsername("dsd");
        usr.setPassword("sld");
        usr.setZipCode("12345");
        usr.setPhoneNumber("2");
        userService.save(usr);

        ux.setFirstName("aods");
        ux.setLastName("csd");
        ux.setEmail("cd@fsdkn.com");
        ux.setUsername("cs");
        ux.setPassword("lbknsvd");
        ux.setZipCode("12345");
        ux.setPhoneNumber("3");
        userService.save(ux);

        ui.setFirstName("oiipo");
        ui.setLastName("vkjn");
        ui.setEmail("lqjiw@fsdkn.com");
        ui.setUsername("dod");
        ui.setPassword("soijcfouej");
        ui.setZipCode("123453");
        ui.setPhoneNumber("4");
        userService.save(ui);


//        em.flush();
//        em.refresh(user);
//        em.refresh(usr);


        List<User> original = new ArrayList<>(userService.findAll());
        List<User> sorted = userService.getUsersListWithFirstAndLastNames(userService.findAll());
        original.sort(new SortUserWithFirstAndLastNames());
        assertEquals (sorted, original);
    }

}
