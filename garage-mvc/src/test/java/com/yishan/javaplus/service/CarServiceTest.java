package com.yishan.javaplus.service;

import com.yishan.javaplus.config.AppConfig;
import com.yishan.javaplus.domain.Car;
import com.yishan.javaplus.domain.Garage;
import com.yishan.javaplus.domain.ParkingTime;
import com.yishan.javaplus.domain.Plate;
import com.yishan.javaplus.repository.CarRepository;
import com.yishan.javaplus.repository.GarageRepository;
import com.yishan.javaplus.repository.PlateRepository;
import com.yishan.javaplus.repository.ParkingTimeRepository;
import org.junit.Ignore;
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
    private GarageRepository garageRepository;

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
        carRepository.save(cc);

        Plate pp = new Plate();
        pp.setCar(cc);
        pp.setState("DC");
        pp.setLicenseNumber("666");
        plateRepository.save(pp);

        ParkingTime pt = new ParkingTime();
        pt.setCar(cc);
        pt.setDays(1);
        pt.setMin(66);
        parkingTimeRepository.save(pt);

        em.flush();
        em.refresh(cc);
        em.refresh(pt);

        Car testCc = carRepository.findByIdWithParkingTime(cc.getId());
        em.refresh(testCc);
        assertNotNull(testCc.getId());
        List<ParkingTime> list = testCc.getParkingTimes();
        list.get(0);
        assertEquals(pt, list.get(0));


    }


    @Test
    @Transactional
    public void findByIdWithGarageTest() {

        Car c2 = new Car();
        c2.setVin("2893409023");
        c2.setModel("Fomula");
        c2.setBodyType("f1");

        Plate p2 = new Plate();
        p2.setCar(c2);
        p2.setState("MD");
        p2.setLicenseNumber("999");

        ParkingTime pt2 = new ParkingTime();
        pt2.setCar(c2);
        pt2.setDays(1);
        pt2.setMin(66);

        Garage garage = new Garage();
        garage.setCar(c2);
        garage.setCity("NY");
        garage.setGarageName("eros");
        garage.setLotNumber(123);

        carRepository.save(c2);
        plateRepository.save(p2);
        parkingTimeRepository.save(pt2);
        garageRepository.save(garage);

        em.flush();
        em.refresh(c2);
        em.refresh(p2);
        em.refresh(pt2);

        Car testCc2 = carRepository.findByIdWithGarage(c2.getId());
        em.refresh(testCc2);
        assertNotNull(testCc2.getId());
        assertEquals(garage, testCc2.getGarage());


    }

}
