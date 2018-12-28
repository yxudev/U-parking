package com.yishan.javaplus.repository;

import com.yishan.javaplus.config.AppConfig;
import com.yishan.javaplus.domain.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class CarRepositoryTest {
    @Autowired
    private CarRepository carRepository;

    @Test
    @Transactional
    public void findByIdTest() {
        Car c = new Car();
        c.setModel("Tesla");
        c.setBodyType("sedan");
        carRepository.save(c);
        Optional<Car> testCar = carRepository.findById(c.getId());
        assertNotNull(testCar);
        assertEquals(c.getId(), testCar.get().getId());
    }
}