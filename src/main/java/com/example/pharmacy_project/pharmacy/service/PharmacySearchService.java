package com.example.pharmacy_project.pharmacy.service;

import com.example.pharmacy_project.pharmacy.cache.PharmacyRedisTemplateService;
import com.example.pharmacy_project.pharmacy.dto.PharmacyDto;
import com.example.pharmacy_project.pharmacy.entity.Pharmacy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PharmacySearchService {
  private final PharmacyRepositoryService pharmacyRepositoryService;
  private final PharmacyRedisTemplateService pharmacyRedisTemplateService;

  public List<PharmacyDto> searchPharmacyDtoList() {

    // redis
    List<PharmacyDto> pharmacyDtoList = pharmacyRedisTemplateService.findAll();
    if(!pharmacyDtoList.isEmpty()) {
      log.info("redis findAll success!");
      return pharmacyDtoList;
    }

    // db
    return pharmacyRepositoryService.findAll()
            .stream()
            .map(this::convertToPharmacyDto)
            .collect(Collectors.toList());
  }

  private PharmacyDto convertToPharmacyDto(Pharmacy pharmacy) {

    return PharmacyDto.builder()
            .id(pharmacy.getId())
            .pharmacyName(pharmacy.getPharmacyName())
            .pharmacyAddress(pharmacy.getPharmacyAddress())
            .latitude(pharmacy.getLatitude())
            .longitude(pharmacy.getLongitude())
            .build();
  }
}
