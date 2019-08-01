package com.yishan.javaplus.api;


import com.yishan.javaplus.domain.Garage;
import com.yishan.javaplus.service.GarageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/api/garages", "/api/garage"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class GarageController {
    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private GarageService garageService;

    @RequestMapping(method = RequestMethod.POST)
    public Garage createNewGarage(@RequestBody Garage garage) {
        return garageService.addGarage(garage);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Garage> getGarageList() {
        logger.debug("list cars");
        return garageService.findAll();
    }

    @RequestMapping(value = "/{Id}", method = RequestMethod.GET)
    public Garage getGarageById(@PathVariable("Id") Long garageId) {
        logger.debug("list garages by id:" + garageId);
        Garage resId = garageService.findById(garageId);
        return resId;
    }

    @RequestMapping(method = RequestMethod.GET, params = {"city"})
    public Garage getGarageByCity(@RequestParam("city") String city) {
        logger.debug("parameter name is: " + city);
        Garage resCity = garageService.findByCity(city);
        return resCity;
    }

    @RequestMapping(method = RequestMethod.GET, params = {"lotNumber"})
    public Garage getGarageByLotNumber(@RequestParam("lotNumber") int lotNumber) {
        logger.debug("your lot number is: " + lotNumber);
        Garage resLot = garageService.findByLotNumber(lotNumber);
        return resLot;
    }


    @RequestMapping(method = RequestMethod.GET, params = {"garageName"})
    public Garage getGarageByGarageName(@RequestParam("garageName") String garageName) {
        logger.debug("Not your average garage: " + garageName);
        Garage resName = garageService.findByGarageName(garageName);
        return resName;
    }


    @RequestMapping(value ="/{Id}", method = RequestMethod.PATCH)
    public Garage PatchLotNumber(@PathVariable("Id") Long garageId, @RequestParam("lotNumber") int lotNumber) {
        logger.debug("New lot number will be: " + lotNumber);
        Garage garage = garageService.findById(garageId);
        Garage resLot2 = garageService.updateLotNumber(garage, lotNumber);
        return resLot2;

    }

}
