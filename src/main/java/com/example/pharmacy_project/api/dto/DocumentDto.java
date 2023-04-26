package com.example.pharmacy_project.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentDto {

  @JsonProperty("address_name")
  private String addressName;

  @JsonProperty("x")
  private double latitude;

  @JsonProperty("y")
  private double longitude;
}
