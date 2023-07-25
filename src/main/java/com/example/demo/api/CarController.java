package com.example.demo.api;

import com.example.demo.model.Car;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/car")
@RestController
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }
    @PostMapping
    public void addCar(@RequestBody Car car){
        carService.addCar(car);
    }
    @GetMapping
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }
    @GetMapping(path="{apartmentNo}")
    public Car getCarByApartmentNo(@PathVariable("apartmentNo") int apartmentNo){
        return carService.getCarByApartmentNo(apartmentNo).orElse(null);

    }
    @DeleteMapping
    public void deleteCarByApartmentNo(@PathVariable("apartmentNo") int apartmentNo ){
        carService.deleteCar(apartmentNo);
    }
    @PutMapping(path = "{apartmentNo}")
    public void updateCar(@PathVariable("apartmentNo") int apartmentNo ,@RequestBody Car newcar){
        carService.updateCar(apartmentNo, newcar);

    }

}
