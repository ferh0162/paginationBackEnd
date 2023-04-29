package com.example.pagination.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarResponse {

  private int id;
  private String brand;
  private String model;
  private String color;
  private int kilometers;

}
