package com.example.demo.dao;

import com.example.demo.model.Car;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CarDao {

    int insertCar(UUID id, Car car);
    default int insertCar(Car car){
        UUID id=UUID.randomUUID();
        return insertCar(id,car);

    }
     List<Car> selectAllCar();
    int deletePersonByApartmentNo(int apartmentNo);
    int updateCarByApartmentNo(int apartmentNo,Car car);

    Optional<Car> selectCarByApartmentNo(int apartmentNo);



}
