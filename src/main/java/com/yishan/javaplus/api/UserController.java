//package com.yishan.javaplus.api;
//
//import com.yishan.javaplus.domain.User;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Repository;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Controller
//@Repository
//@RequestMapping(value = {"/api/users", "/api/user"},produces = MediaType.APPLICATION_JSON_VALUE)
//public class UserController {
//
//        private final Logger logger = LoggerFactory.getLogger(getClass());
//
//
////        @Autowired
////        @Qualifier(BeanIds.AUTHENTICATION_MANAGER)
////        private AuthenticationManager authenticationManager;
//
//    @RequestMapping(method = RequestMethod.GET)
//    public List<User> getUserList(){
//        logger.debug("list users");
//        return new ArrayList<User>();
//
//
//    }
//
//    }
