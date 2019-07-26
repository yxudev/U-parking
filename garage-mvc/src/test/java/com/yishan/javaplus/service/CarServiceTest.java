package com.yishan.javaplus.service;

import com.yishan.javaplus.config.AppConfig;
import com.yishan.javaplus.config.AppConfig;
import com.yishan.javaplus.domain.Car;
import com.yishan.javaplus.domain.Plate;
import com.yishan.javaplus.domain.User;
import com.yishan.javaplus.repository.CarRepository;
import com.yishan.javaplus.repository.PlateRepository;
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
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class CarServiceTest {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private PlateRepository plateRepository;

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    public void findByIdTest() {
        Car c = new Car();
        c.setModel("Tesla");
        c.setBodyType("sedan");
        Optional<Car> testCar = carRepository.findById(c.getId());
        assertNotNull(testCar);
        assertEquals(c.getId(), testCar.get().getId());
    }

    @Test
    @Transactional
    public void findByIdWithPlateTest() {
        Car car = new Car();
        car.setVin("83497158973198");
        car.setModel("BMV");
        car.setBodyType("SUV");
        Plate plate = new Plate();
        plate.setCar(car);
        plate.setState("VA");
        plate.setLicenseNumber("123va");
        carRepository.save(car);
        plateRepository.save(plate);
        em.flush();
        em.refresh(car);
        Car testCar = carRepository.findByIdWithPlate(car.getId());
        em.refresh(testCar);
        assertNotNull(testCar);
        assertEquals(plate, testCar.getPlate());
    }
}
