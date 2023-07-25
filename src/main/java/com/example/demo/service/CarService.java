package com.example.demo.service;

import com.example.demo.dao.CarDao;
import com.example.demo.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarDao carDao;

    @Autowired
    public CarService(@Qualifier("MSSQL") CarDao carDao) {
        this.carDao = carDao;
    }

    public int addCar(Car car){
        return carDao.insertCar(car);

    }
    public List<Car> getAllCars(){
        return carDao.selectAllCar();

    }
    public Optional<Car> getCarByApartmentNo(int apartmentNo){
        return carDao.selectCarByApartmentNo(apartmentNo);
    }
    public int deleteCar(int apartmentNo){
        return carDao.deletePersonByApartmentNo(apartmentNo);

    }
    public int updateCar(int apartmentNo,Car car){
        return carDao.updateCarByApartmentNo(apartmentNo,car);

    }
}
