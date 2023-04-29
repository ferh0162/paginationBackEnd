package com.example.pagination.api;

import com.example.pagination.dto.CarRequest;
import com.example.pagination.dto.CarResponse;
import com.example.pagination.entity.Car;
import com.example.pagination.repository.CarRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/car")
@CrossOrigin
public class CarController {
  CarRepository carRepository;


  public CarController(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  @GetMapping
  public List<Car> getCars(Pageable pageable){
    Page carPage = carRepository.findAll(pageable);
    return carPage.getContent();
  }


  @GetMapping("/brand/{brand}")
  public List<Car> getCarsByBrand(@PathVariable String brand, Pageable pageable) {
    Page<Car> carPage = carRepository.findByBrand(brand, pageable);
    return carPage.getContent();
  }

  @GetMapping("/allCarsAmount")
  public long getAllCarsAmount(){
    return carRepository.count();
  }

  @GetMapping("/id/{id}")
  public Car getCarFromId(@PathVariable Integer id){
    Car car = carRepository.findCarById(id);
    return car;
  }
  @GetMapping("/addcars")
  public String addCars(){
    return "addCar";
  }
  @PostMapping("/addCar")
  public CarResponse addCar(@RequestBody CarRequest body) {
    Car car = new Car();
    car.setBrand(body.getBrand());
    car.setModel(body.getModel());
    car.setColor(body.getColor());
    car.setKilometers(body.getKilometers());
    car.setCreated(LocalDateTime.now());
    car.setUpdated(LocalDateTime.now());
    Car savedCar = carRepository.save(car);

    CarResponse response = new CarResponse();
    response.setId(savedCar.getId());
    response.setBrand(savedCar.getBrand());
    response.setModel(savedCar.getModel());
    response.setColor(savedCar.getColor());
    response.setKilometers(savedCar.getKilometers());
    return response;
  }

  @DeleteMapping("deletecar/{id}")
  public CarResponse deleteCar(@PathVariable int id){
    Car car = carRepository.findCarById(id);
   carRepository.delete(car);

    CarResponse response = new CarResponse();
    response.setId(car.getId());
    response.setBrand(car.getBrand());
    response.setModel(car.getModel());
    response.setColor(car.getColor());
    response.setKilometers(car.getKilometers());

    return response;
  }

}
