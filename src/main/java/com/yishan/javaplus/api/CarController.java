package com.yishan.javaplus.api;

import com.yishan.javaplus.domain.Car;
import com.yishan.javaplus.repository.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


    @Controller
    @Repository
    @RequestMapping(value = {"/api/cars", "/api/car"},produces = MediaType.APPLICATION_JSON_VALUE)
    public class    CarController {

        private final Logger logger = LoggerFactory.getLogger(getClass());


//    private final AuthenticationManager authenticationManager;

//    @Autowired
//    public UserController(@Qualifier(BeanIds.AUTHENTICATION_MANAGER) AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }
    @Autowired
    private CarRepository carRepository;

        @RequestMapping(method = RequestMethod.GET)
        public List<Car > getUserList(){
            logger.debug("list cars");
            return carRepository.findAll();


        }
    }
