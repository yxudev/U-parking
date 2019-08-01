package com.yishan.javaplus.extend.security;

import com.yishan.javaplus.domain.User;
import com.yishan.javaplus.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username){
        User domainUser = null;
        try {
            domainUser = userService.findByUsername(username);
        }
        catch (Exception repositoryProblem){
            logger.debug("catch AuthenticationServiceException from AuthenticationProvider");
        }
        //TODO  findAuthoritesByUserId;

        //TODO unit test



        return domainUser;
    }
}