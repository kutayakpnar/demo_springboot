package com.example.demo.dao;

import com.example.demo.model.Car;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("FakeDao")
public class FakeCarDataAcces implements CarDao{
    private static List<Car> DB=new ArrayList<>();
    @Override
    public int insertCar(UUID id, Car car) {
        DB.add(new Car(id, car.getModalName(),car.getApartmentNo()));
        return 1;
    }

    @Override
    public List<Car> selectAllCar() {
        return DB;
    }

    @Override
    public int deletePersonByApartmentNo(int apartmentNo) {
        Optional<Car> carMaybe=selectCarByApartmentNo(apartmentNo);
        if(carMaybe.isEmpty()){
            return 0;
        }
        DB.remove(carMaybe.get());
        return 1;
    }

    @Override
    public int updateCarByApartmentNo(int apartmentNo, Car update) {
        return selectCarByApartmentNo(apartmentNo)
                .map(car->{
            int indexOfPersonToDelete= DB.indexOf(car);
            if(indexOfPersonToDelete>=0){
                DB.set(indexOfPersonToDelete,new Car(update.getId(),update.getModalName(),apartmentNo));
                return 1;
            }
            return 0;
        } ).orElse(0);
    }

    @Override
    public Optional<Car> selectCarByApartmentNo(int apartmentNo) {
        return DB.stream()
                .filter(car -> car.getApartmentNo()==apartmentNo).findFirst();
    }

}
