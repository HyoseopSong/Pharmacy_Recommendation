package com.example.pharmacy_project.direction.entity;

import com.example.pharmacy_project.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "direction")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Direction extends BaseTimeEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String inputAddress;
  private double inputLatitude;
  private double inputLongitude;

  private String targetPharmacyName;
  private String targetAddress;
  private double targetLatitude;
  private double targetLongitude;

  private double distance;
}
