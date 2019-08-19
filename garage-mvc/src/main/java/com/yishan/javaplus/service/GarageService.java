package com.yishan.javaplus.service;

import com.yishan.javaplus.domain.Garage;
import com.yishan.javaplus.repository.GarageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GarageService {

    @Autowired
    private GarageRepository garageRepository;

    @Transactional
    public Garage createNewGarage(Garage newGarage) {
        String code = UUID.randomUUID().toString();
        save(newGarage);
        return newGarage;
    }

    public String GarageId = UUID.randomUUID().toString();



    @Transactional
    public Garage addGarage(Garage garage) {
        int lotNumber = garage.getLotNumber();
        String garageName = garage.getGarageName();
        String city = garage.getCity();
        garage.setLotNumber(lotNumber);
        garage.setGarageName(garageName);
        garage.setCity(city);
        save(garage);
        return garage;
    }

    public GarageService() {

    }

    public List<Garage> findAll() {
        return garageRepository.findAll();
    }

    public Garage findByIdWithGar(Long Id) {
        return garageRepository.findByIdWithGar(Id);
}

    public Garage findById(Long Id){
        return garageRepository.findById(Id).get();
    }

    public Garage findByGarageName(String GarageName) {
        return garageRepository.findByGarageName(GarageName);
    }

    public Garage findByCity(String City) {
        return garageRepository.findByCity(City);
    }

    public Garage findByLotNumber(int LotNumber) {
        return garageRepository.findByLotNumber(LotNumber);
    }


    public Garage save(Garage garage) {
        return garageRepository.save(garage);
    }



    public Garage deleteGarageById(Long Id) {
        return garageRepository.deleteGarageById(Id);
    }


    @Transactional
    public Garage updateLotNumber(Garage garage1, int lotNumber) {

        garage1.setLotNumber(lotNumber);
        return garageRepository.save(garage1);

    }

    @Transactional
    public Garage reNewGarage(Garage garage2) {
            return garageRepository.save(garage2);

    }

}
