package com.yishan.javaplus.api;

import com.yishan.javaplus.domain.Car;
import com.yishan.javaplus.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/api/cars", "/api/car"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class CarController {

    private final Logger logger = LoggerFactory.getLogger(getClass());


//    private final AuthenticationManager authenticationManager;

    //    @Autowired
//    public UserController(@Qualifier(BeanIds.AUTHENTICATION_MANAGER) AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }
//        @Autowired
//        private CarRepository carRepository;

    @Autowired
    private CarService carService;
    private Object Vin;

    @RequestMapping(method = RequestMethod.POST)
    public Car generateCar(@RequestBody Car car) {
        return carService.save(car);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Car> getCarList(Long carId) {
        logger.debug("list cars");
        return carService.findAll();
    }

//            @RequestMapping(value = "/{Id}", method = RequestMethod.GET)
//            @JasonView(Car.WithImageView.class)
//            public Car getCarById(@PathVariable PathVariable("Id") Long carId){
//                logger.debug("id is: "+carId);
//                return carService.findBy(new Car(carId)).get();

    @RequestMapping(value = "/{Id}", method = RequestMethod.GET)
    public Car getCarById(@PathVariable("Id") Long carId) {
        logger.debug("list cars by id:" + carId);
        Car result = carService.findById(carId);
        return result;
    }

    @RequestMapping(method = RequestMethod.GET, params = {"vin"})
    public Car getCarByVin(@RequestParam("vin") String vin) {
        logger.debug("parameter name is: " + vin);
        //logger.debug("encoding header is : " + encoding);
        Car result = carService.findByVin(vin);
        return result;
        //   return CarService.findBy(new Car(carId)).get();
    }
}
