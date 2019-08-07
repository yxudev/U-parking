package com.yishan.javaplus.extend.security;


import com.yishan.javaplus.config.AppConfig;
import com.yishan.javaplus.domain.Authority;
import com.yishan.javaplus.domain.User;
import com.yishan.javaplus.repository.AuthorityRepository;
import com.yishan.javaplus.repository.UserRepository;
import com.yishan.javaplus.service.AuthorityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class UserDetailsServiceImplTest extends UserDetailsServiceImpl{

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager entityManager;



    @Test
    @Transactional
    public void loadUserByUsernameTest(){
        User user = new User();
        Authority authority = new Authority();
        user.setUsername("usr");
        user.setLastName("last");
        user.setFirstName("first");
        user.setPassword("halashdsafals");
        user.setEmail("j.logan@gmail.com ");
        user.setPhoneNumber("123-456-7899");
        user.setZipCode("20001");

        authority.setAuthority("Admin");
        authority.setUser(user);
        userRepository.save(user);
        authorityRepository.save(authority);

        entityManager.flush();
        entityManager.refresh(user);
//        entityManager.refresh(authority);

        List<Authority> authorities = authorityService.findAuthorityByUser(user);
        for (Authority authority1 : authorities){
            assertEquals(authority1,authority);
        }


    }

}
