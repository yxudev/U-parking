package com.yishan.javaplus.service;

import com.yishan.javaplus.config.AppConfig;
import com.yishan.javaplus.domain.Car;
import com.yishan.javaplus.domain.ParkingTime;
import com.yishan.javaplus.domain.Plate;
import com.yishan.javaplus.repository.CarRepository;
import com.yishan.javaplus.repository.PlateRepository;
import com.yishan.javaplus.repository.ParkingTimeRepository;
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
    private ParkingTimeRepository parkingTimeRepository;

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    public void findByIdTest() {
        Car c = new Car();
        c.setModel("Tesla");
        c.setBodyType("sedan");
        carRepository.save(c);
//        em.flush();
//        em.refresh(c);
        Optional<Car> testCa = carRepository.findById(c.getId());
        assertNotNull(testCa);
        assertEquals(c.getId(), testCa.get().getId());
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

    @Test
    @Transactional
    public void findByIdWithParkingTimeTest() {
        Car cc = new Car();
        cc.setVin("8934758918");
        cc.setModel("Benz");
        cc.setBodyType("sedan");
        Plate pp = new Plate();
        pp.setState("DC");
        pp.setLicenseNumber("666");
        ParkingTime pt = new ParkingTime();
        pt.setCar(cc);
        pt.setDays(1);
        pt.setMin(66);
        carRepository.save(cc);
        plateRepository.save(pp);
        parkingTimeRepository.save(pt);
        em.flush();
        em.refresh(cc);
        Car testCc = carRepository.findByIdWithParkingTime(cc.getId());
        em.refresh(testCc);
        assertNotNull(testCc);
        assertEquals(pt, testCc.getParkingTimes());

    }
}
