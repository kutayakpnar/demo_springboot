package com.example.demo.dao;

import com.example.demo.model.Car;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository("MSSQL")
public class CarDataAcces implements CarDao{
    int apartmentNo=0;

    @Override
    public int insertCar(UUID id, Car car) {
        return 0;
    }

    @Override
    public List<Car> selectAllCar() {
        apartmentNo++;
        return List.of(new Car(UUID.randomUUID(),"FROM MSSQL DB",apartmentNo));
    }

    @Override
    public int deletePersonByApartmentNo(int apartmentNo) {
        return 0;
    }

    @Override
    public int updateCarByApartmentNo(int apartmentNo, Car car) {
        return 0;
    }

    @Override
    public Optional<Car> selectCarByApartmentNo(int apartmentNo) {
        return Optional.empty();
    }
}
