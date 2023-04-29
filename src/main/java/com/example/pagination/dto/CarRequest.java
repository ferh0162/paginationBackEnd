package com.example.pagination.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
public class CarRequest { //Hvad vi forventer som input. Hvad man som bruger som ind

  private String brand;
  private String model;
  private String color;
  private int kilometers;
}
