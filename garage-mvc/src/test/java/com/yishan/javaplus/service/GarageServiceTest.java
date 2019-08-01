package com.yishan.javaplus.service;


import com.yishan.javaplus.config.AppConfig;
import com.yishan.javaplus.domain.Garage;
import com.yishan.javaplus.repository.GarageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class GarageServiceTest {
    @Autowired
    private GarageRepository garageRepository;

    @Autowired
    private GarageService garageService;


    @Test
    @Transactional
    public void updateLotNumberTest(){
        Garage garage = new Garage();


        garage.setLotNumber(1);
        garage.setCity("NY");
        garage.setGarageName("kjhsfjasn");
        garageRepository.save(garage);
//        em.flush();
//        em.refresh(c);

        garageService.updateLotNumber(garage, 2);

        Optional<Garage> testGa = garageRepository.findById(garage.getId());
        assertNotNull(testGa);
        assertEquals(garage.getLotNumber(), testGa.get().getLotNumber());


    }
}
