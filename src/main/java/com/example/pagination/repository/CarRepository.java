package com.example.pagination.repository;

import com.example.pagination.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
  Page<Car> findByBrand(String brand, Pageable pageable);

  Car findCarById(Integer id);


}
