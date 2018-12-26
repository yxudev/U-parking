package javaplus.repository;

import javaplus.config.AppConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class CarRepositoryTest{

//    @Test
//    @Transactional
//    public void findByIdTest() {
//        Car c = new Car();
//        c.setBrand("toyota");
//        c.setModel("xle");
//        carRepository.save(c);
//        Optional<Car> testCar = carRepository.findById(c.getId());
//        assertNotNull(testCar);
//        assertEquals(c.getId(),testCar.get().getId());
//    }



}
