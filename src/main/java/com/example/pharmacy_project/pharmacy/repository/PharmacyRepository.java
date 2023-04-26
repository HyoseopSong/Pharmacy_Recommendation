package com.example.pharmacy_project.pharmacy.repository;

import com.example.pharmacy_project.pharmacy.entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {
}
